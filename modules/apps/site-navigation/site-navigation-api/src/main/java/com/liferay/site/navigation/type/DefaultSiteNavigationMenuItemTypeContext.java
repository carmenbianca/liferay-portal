/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.type;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;

import java.util.Optional;

/**
 * @author Pavel Savinov
 */
public class DefaultSiteNavigationMenuItemTypeContext
	implements SiteNavigationMenuItemTypeContext {

	public DefaultSiteNavigationMenuItemTypeContext(Company company) {
		_company = company;
	}

	public DefaultSiteNavigationMenuItemTypeContext(Group group) {
		_company = CompanyLocalServiceUtil.fetchCompany(group.getCompanyId());
		_group = group;
	}

	public Company getCompany() {
		return _company;
	}

	public Optional<Group> getGroupOptional() {
		return Optional.of(_group);
	}

	private final Company _company;
	private Group _group;

}