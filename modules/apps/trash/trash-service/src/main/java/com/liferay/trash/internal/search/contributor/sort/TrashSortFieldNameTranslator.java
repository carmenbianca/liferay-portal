/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.internal.search.contributor.sort;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.contributor.ContributorConstants;
import com.liferay.portal.search.contributor.sort.SortFieldNameTranslator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = ContributorConstants.ENTRY_CLASS_NAME_PROPERTY_KEY + "=com.liferay.trash.model.TrashEntry",
	service = SortFieldNameTranslator.class
)
public class TrashSortFieldNameTranslator implements SortFieldNameTranslator {

	@Override
	public String getSortFieldName(String orderByCol) {
		if (orderByCol.equals("removed-date")) {
			return Field.REMOVED_DATE;
		}
		else if (orderByCol.equals("removed-by")) {
			return Field.REMOVED_BY_USER_NAME;
		}

		return orderByCol;
	}

}