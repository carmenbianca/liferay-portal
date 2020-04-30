/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.organizations.internal.search.contributor.sort;

import com.liferay.portal.search.contributor.ContributorConstants;
import com.liferay.portal.search.contributor.sort.SortFieldNameTranslator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Igor Fabiano Nazar
 */
@Component(
	immediate = true,
	property = ContributorConstants.ENTRY_CLASS_NAME_PROPERTY_KEY + "=com.liferay.portal.kernel.model.Organization",
	service = SortFieldNameTranslator.class
)
public class OrganizationSortFieldNameTranslator
	implements SortFieldNameTranslator {

	@Override
	public String getSortFieldName(String orderByCol) {
		if (orderByCol.equals("name")) {
			return "name";
		}
		else if (orderByCol.equals("type")) {
			return "type";
		}

		return orderByCol;
	}

}