/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.admin.web.internal.portlet.configuration.icon;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.configuration.icon.BasePortletConfigurationIcon;
import com.liferay.portal.kernel.portlet.configuration.icon.PortletConfigurationIcon;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.RoleService;
import com.liferay.portal.kernel.service.permission.RolePermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.roles.admin.constants.RolesAdminPortletKeys;
import com.liferay.roles.admin.role.type.contributor.RoleTypeContributor;
import com.liferay.roles.admin.web.internal.role.type.contributor.util.RoleTypeContributorRetrieverUtil;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pei-Jung Lan
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + RolesAdminPortletKeys.ROLES_ADMIN,
		"path=/edit_role.jsp", "path=/edit_role_assignments.jsp",
		"path=/edit_role_permissions.jsp"
	},
	service = PortletConfigurationIcon.class
)
public class DeleteRolePortletConfigurationIcon
	extends BasePortletConfigurationIcon {

	@Override
	public String getMessage(PortletRequest portletRequest) {
		return LanguageUtil.get(
			getResourceBundle(getLocale(portletRequest)), "delete");
	}

	@Override
	public String getURL(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		try {
			PortletURL portletURL = PortletURLFactoryUtil.create(
				portletRequest, RolesAdminPortletKeys.ROLES_ADMIN,
				PortletRequest.ACTION_PHASE);

			portletURL.setParameter(ActionRequest.ACTION_NAME, "deleteRole");
			portletURL.setParameter("mvcPath", "/view.jsp");
			portletURL.setParameter(
				"roleId", String.valueOf(_getRoleId(portletRequest)));

			return portletURL.toString();
		}
		catch (Exception exception) {
		}

		return StringPool.BLANK;
	}

	@Override
	public double getWeight() {
		return 101;
	}

	@Override
	public boolean isShow(PortletRequest portletRequest) {
		try {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)portletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			long roleId = _getRoleId(portletRequest);

			Role role = _roleService.fetchRole(roleId);

			RoleTypeContributor currentRoleTypeContributor =
				RoleTypeContributorRetrieverUtil.getCurrentRoleTypeContributor(
					portletRequest);

			if (currentRoleTypeContributor.isAllowDelete(role) &&
				RolePermissionUtil.contains(
					themeDisplay.getPermissionChecker(), roleId,
					ActionKeys.DELETE)) {

				return true;
			}

			return false;
		}
		catch (PortalException portalException) {
			_log.error(portalException, portalException);
		}

		return false;
	}

	@Reference(unbind = "-")
	protected void setRoleService(RoleService roleService) {
		_roleService = roleService;
	}

	private long _getRoleId(PortletRequest portletRequest) {
		return ParamUtil.getLong(
			_portal.getHttpServletRequest(portletRequest), "roleId");
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DeleteRolePortletConfigurationIcon.class);

	@Reference
	private Portal _portal;

	private RoleService _roleService;

}