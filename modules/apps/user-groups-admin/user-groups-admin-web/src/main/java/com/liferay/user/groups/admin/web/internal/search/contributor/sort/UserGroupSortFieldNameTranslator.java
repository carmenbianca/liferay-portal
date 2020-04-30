/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.groups.admin.web.internal.search.contributor.sort;

import com.liferay.portal.search.contributor.ContributorConstants;
import com.liferay.portal.search.contributor.sort.SortFieldNameTranslator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = ContributorConstants.ENTRY_CLASS_NAME_PROPERTY_KEY + "=com.liferay.portal.kernel.model.UserGroup",
	service = SortFieldNameTranslator.class
)
public class UserGroupSortFieldNameTranslator
	implements SortFieldNameTranslator {

	@Override
	public String getSortFieldName(String orderByCol) {
		if (orderByCol.equals("description")) {
			return "description";
		}
		else if (orderByCol.equals("name")) {
			return "name";
		}

		return orderByCol;
	}

}