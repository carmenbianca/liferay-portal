/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.impl;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceMode;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.PortletConstants;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.Team;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionUtil;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.service.permission.TeamPermissionUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.service.base.PermissionServiceBaseImpl;
import com.liferay.registry.collections.ServiceTrackerCollections;
import com.liferay.registry.collections.ServiceTrackerMap;

import java.util.List;

/**
 * Provides the remote service for checking permissions.
 *
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class PermissionServiceImpl extends PermissionServiceBaseImpl {

	/**
	 * Checks to see if the group has permission to the service.
	 *
	 * @param groupId the primary key of the group
	 * @param name the service name
	 * @param primKey the primary key of the service
	 */
	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	@Override
	public void checkPermission(long groupId, String name, long primKey)
		throws PortalException {

		checkPermission(
			getPermissionChecker(), groupId, name, String.valueOf(primKey));
	}

	/**
	 * Checks to see if the group has permission to the service.
	 *
	 * @param groupId the primary key of the group
	 * @param name the service name
	 * @param primKey the primary key of the service
	 */
	@Override
	public void checkPermission(long groupId, String name, String primKey)
		throws PortalException {

		checkPermission(getPermissionChecker(), groupId, name, primKey);
	}

	protected boolean checkBaseModelPermission(
			PermissionChecker permissionChecker, long groupId, String className,
			long classPK)
		throws PortalException {

		String actionId = ActionKeys.PERMISSIONS;

		if (className.equals(Team.class.getName())) {
			className = Group.class.getName();

			Team team = teamLocalService.fetchTeam(classPK);

			classPK = team.getGroupId();

			actionId = ActionKeys.MANAGE_TEAMS;
		}

		ModelResourcePermission<?> modelResourcePermission =
			_modelPermissions.getService(className);

		if (modelResourcePermission != null) {
			PortletResourcePermission portletResourcePermission =
				modelResourcePermission.getPortletResourcePermission();

			if (portletResourcePermission == null) {
				modelResourcePermission.check(
					permissionChecker, classPK, actionId);

				return true;
			}

			ModelResourcePermissionUtil.check(
				modelResourcePermission, permissionChecker, groupId, classPK,
				actionId);

			return true;
		}

		BaseModelPermissionChecker baseModelPermissionChecker =
			_baseModelPermissionCheckers.getService(className);

		if (baseModelPermissionChecker != null) {
			baseModelPermissionChecker.checkBaseModel(
				permissionChecker, groupId, classPK, actionId);

			return true;
		}

		return false;
	}

	protected void checkPermission(
			PermissionChecker permissionChecker, long groupId, String name,
			String primKey)
		throws PortalException {

		if (checkBaseModelPermission(
				permissionChecker, groupId, name,
				GetterUtil.getLong(primKey))) {

			return;
		}

		if ((primKey != null) &&
			primKey.contains(PortletConstants.LAYOUT_SEPARATOR)) {

			int pos = primKey.indexOf(PortletConstants.LAYOUT_SEPARATOR);

			long plid = GetterUtil.getLong(primKey.substring(0, pos));

			String portletId = primKey.substring(
				pos + PortletConstants.LAYOUT_SEPARATOR.length());

			PortletPermissionUtil.check(
				permissionChecker, groupId, plid, portletId,
				ActionKeys.CONFIGURATION);
		}
		else if (!permissionChecker.hasPermission(
					groupId, name, primKey, ActionKeys.PERMISSIONS)) {

			AssetRendererFactory<?> assetRendererFactory =
				AssetRendererFactoryRegistryUtil.
					getAssetRendererFactoryByClassName(name);

			if (assetRendererFactory != null) {
				try {
					if (assetRendererFactory.hasPermission(
							permissionChecker, GetterUtil.getLong(primKey),
							ActionKeys.PERMISSIONS)) {

						return;
					}
				}
				catch (Exception exception) {
				}
			}

			ResourcePermission resourcePermission =
				resourcePermissionLocalService.getResourcePermission(
					permissionChecker.getCompanyId(), name,
					ResourceConstants.SCOPE_INDIVIDUAL, primKey,
					permissionChecker.getOwnerRoleId());

			if (permissionChecker.hasOwnerPermission(
					permissionChecker.getCompanyId(), name, primKey,
					resourcePermission.getOwnerId(), ActionKeys.PERMISSIONS)) {

				return;
			}

			Role role = null;

			if (name.equals(Role.class.getName())) {
				long roleId = GetterUtil.getLong(primKey);

				role = rolePersistence.findByPrimaryKey(roleId);
			}

			if ((role != null) && role.isTeam()) {
				Team team = teamPersistence.findByPrimaryKey(role.getClassPK());

				TeamPermissionUtil.check(
					permissionChecker, team, ActionKeys.PERMISSIONS);
			}
			else {
				List<String> resourceActions =
					ResourceActionsUtil.getResourceActions(name);

				if (!resourceActions.contains(ActionKeys.DEFINE_PERMISSIONS) ||
					!permissionChecker.hasPermission(
						groupId, name, primKey,
						ActionKeys.DEFINE_PERMISSIONS)) {

					throw new PrincipalException.MustHavePermission(
						permissionChecker, name, Long.valueOf(primKey),
						ActionKeys.DEFINE_PERMISSIONS);
				}
			}
		}
	}

	private static final ServiceTrackerMap<String, BaseModelPermissionChecker>
		_baseModelPermissionCheckers =
			ServiceTrackerCollections.openSingleValueMap(
				BaseModelPermissionChecker.class, "model.class.name");
	private static final ServiceTrackerMap<String, ModelResourcePermission>
		_modelPermissions = ServiceTrackerCollections.openSingleValueMap(
			ModelResourcePermission.class, "model.class.name");

}