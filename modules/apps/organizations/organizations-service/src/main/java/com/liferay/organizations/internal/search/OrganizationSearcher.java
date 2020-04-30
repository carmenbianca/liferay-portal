/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.organizations.internal.search;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;

import org.osgi.service.component.annotations.Component;

/**
 * @author Igor Fabiano Nazar
 * @author Luan Maoski
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.portal.kernel.model.Organization",
	service = BaseSearcher.class
)
public class OrganizationSearcher extends BaseSearcher {

	public static final String CLASS_NAME = Organization.class.getName();

	public OrganizationSearcher() {
		setDefaultSelectedFieldNames(
			Field.COMPANY_ID, Field.ORGANIZATION_ID, Field.UID);
		setPermissionAware(true);
		setStagingAware(false);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}