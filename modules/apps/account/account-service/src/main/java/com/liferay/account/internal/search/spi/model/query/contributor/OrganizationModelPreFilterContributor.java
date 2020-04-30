/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.internal.search.spi.model.query.contributor;

import com.liferay.account.constants.AccountConstants;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.ExistsFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pei-Jung Lan
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.portal.kernel.model.Organization",
	service = ModelPreFilterContributor.class
)
public class OrganizationModelPreFilterContributor
	implements ModelPreFilterContributor {

	@Override
	public void contribute(
		BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
		SearchContext searchContext) {

		long[] accountEntryIds = (long[])searchContext.getAttribute(
			"accountEntryIds");

		if (ArrayUtil.isNotEmpty(accountEntryIds)) {
			if ((accountEntryIds.length == 1) &&
				(accountEntryIds[0] == AccountConstants.ACCOUNT_ENTRY_ID_ANY)) {

				ExistsFilter accountEntryIdsExistsFilter = new ExistsFilter(
					"accountEntryIds");

				booleanFilter.add(
					accountEntryIdsExistsFilter, BooleanClauseOccur.MUST);
			}
			else {
				TermsFilter accountEntryTermsFilter = new TermsFilter(
					"accountEntryIds");

				accountEntryTermsFilter.addValues(
					ArrayUtil.toStringArray(accountEntryIds));

				booleanFilter.add(
					accountEntryTermsFilter, BooleanClauseOccur.MUST);
			}
		}
	}

}