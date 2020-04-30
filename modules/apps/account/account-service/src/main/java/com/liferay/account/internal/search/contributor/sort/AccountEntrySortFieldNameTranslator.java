/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.internal.search.contributor.sort;

import com.liferay.portal.search.contributor.ContributorConstants;
import com.liferay.portal.search.contributor.sort.SortFieldNameTranslator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Drew Brokke
 */
@Component(
	immediate = true,
	property = ContributorConstants.ENTRY_CLASS_NAME_PROPERTY_KEY + "=com.liferay.account.model.AccountEntry",
	service = SortFieldNameTranslator.class
)
public class AccountEntrySortFieldNameTranslator
	implements SortFieldNameTranslator {

	@Override
	public String getSortFieldName(String orderByCol) {
		return orderByCol;
	}

}