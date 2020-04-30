/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.admin.internal.role.type.contributor;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.util.PropsValues;
import com.liferay.roles.admin.role.type.contributor.RoleTypeContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Drew Brokke
 */
@Component(
	immediate = true, property = "service.ranking:Integer=200",
	service = RoleTypeContributor.class
)
public class SiteRoleTypeContributor implements RoleTypeContributor {

	@Override
	public String[] getExcludedRoleNames() {
		return new String[] {
			RoleConstants.SITE_ADMINISTRATOR, RoleConstants.SITE_OWNER
		};
	}

	@Override
	public String getIcon() {
		return "globe";
	}

	@Override
	public String getName() {
		return "site";
	}

	@Override
	public String[] getSubtypes() {
		return PropsValues.ROLES_SITE_SUBTYPES;
	}

	@Override
	public String getTabTitle(Locale locale) {
		return "site-roles";
	}

	@Override
	public String getTitle(Locale locale) {
		return "site-role";
	}

	@Override
	public int getType() {
		return RoleConstants.TYPE_SITE;
	}

	@Override
	public boolean isAllowAssignMembers(Role role) {
		return false;
	}

	@Override
	public boolean isAllowDelete(Role role) {
		if (role == null) {
			return false;
		}

		return !_portal.isSystemRole(role.getName());
	}

	@Reference
	private Portal _portal;

}