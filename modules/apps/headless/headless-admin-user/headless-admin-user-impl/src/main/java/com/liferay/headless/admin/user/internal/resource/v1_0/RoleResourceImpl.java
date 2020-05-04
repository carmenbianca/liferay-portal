/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.admin.user.internal.resource.v1_0;

import com.liferay.headless.admin.user.dto.v1_0.Role;
import com.liferay.headless.admin.user.internal.dto.v1_0.util.CreatorUtil;
import com.liferay.headless.admin.user.resource.v1_0.RoleResource;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.RoleService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.LocalizedMapUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Javier Gamarra
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/role.properties",
	scope = ServiceScope.PROTOTYPE, service = RoleResource.class
)
public class RoleResourceImpl extends BaseRoleResourceImpl {

	@Override
	public Role getRole(Long roleId) throws Exception {
		return _toRole(_roleService.getRole(roleId));
	}

	@Override
	public Page<Role> getRolesPage(Pagination pagination) throws Exception {
		Integer[] types = {
			RoleConstants.TYPE_ORGANIZATION, RoleConstants.TYPE_REGULAR,
			RoleConstants.TYPE_SITE
		};

		return Page.of(
			transform(
				_roleService.search(
					contextCompany.getCompanyId(), null, types, null,
					pagination.getStartPosition(), pagination.getEndPosition(),
					null),
				this::_toRole),
			pagination,
			_roleService.searchCount(
				contextCompany.getCompanyId(), null, types, null));
	}

	private Role _toRole(com.liferay.portal.kernel.model.Role role)
		throws Exception {

		return new Role() {
			{
				availableLanguages = LocaleUtil.toW3cLanguageIds(
					role.getAvailableLanguageIds());
				creator = CreatorUtil.toCreator(
					_portal, _userLocalService.getUserById(role.getUserId()));
				dateCreated = role.getCreateDate();
				dateModified = role.getModifiedDate();
				description = role.getDescription(
					contextAcceptLanguage.getPreferredLocale());
				description_i18n = LocalizedMapUtil.getI18nMap(
					contextAcceptLanguage.isAcceptAllLanguages(),
					role.getDescriptionMap());
				id = role.getRoleId();
				name = role.getTitle(
					contextAcceptLanguage.getPreferredLocale());
				name_i18n = LocalizedMapUtil.getI18nMap(
					contextAcceptLanguage.isAcceptAllLanguages(),
					role.getTitleMap());
				roleType = role.getTypeLabel();
			}
		};
	}

	@Reference
	private Portal _portal;

	@Reference
	private RoleService _roleService;

	@Reference
	private UserLocalService _userLocalService;

}