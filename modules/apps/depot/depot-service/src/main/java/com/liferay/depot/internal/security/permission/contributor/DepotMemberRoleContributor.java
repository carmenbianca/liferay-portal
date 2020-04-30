/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.internal.security.permission.contributor;

import com.liferay.depot.constants.DepotRolesConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.security.permission.UserBag;
import com.liferay.portal.kernel.security.permission.contributor.RoleCollection;
import com.liferay.portal.kernel.security.permission.contributor.RoleContributor;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;

import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Cristina González
 */
@Component(service = RoleContributor.class)
public class DepotMemberRoleContributor implements RoleContributor {

	@Override
	public void contribute(RoleCollection roleCollection) {
		if (roleCollection.getGroupId() <= 0) {
			return;
		}

		try {
			Group group = _groupLocalService.getGroup(
				roleCollection.getGroupId());

			UserBag userBag = roleCollection.getUserBag();

			if (Objects.equals(GroupConstants.TYPE_DEPOT, group.getType()) &&
				(userBag.hasUserGroup(group) ||
				 userBag.hasUserOrgGroup(group))) {

				Role role = _roleLocalService.getRole(
					group.getCompanyId(),
					DepotRolesConstants.ASSET_LIBRARY_MEMBER);

				roleCollection.addRoleId(role.getRoleId());
			}
		}
		catch (PortalException portalException) {
			_log.error(portalException, portalException);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DepotMemberRoleContributor.class);

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private RoleLocalService _roleLocalService;

}