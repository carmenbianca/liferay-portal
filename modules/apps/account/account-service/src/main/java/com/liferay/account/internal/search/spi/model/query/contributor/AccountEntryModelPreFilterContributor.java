/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.internal.search.spi.model.query.contributor;

import com.liferay.account.constants.AccountConstants;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Drew Brokke
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.account.model.AccountEntry",
	service = ModelPreFilterContributor.class
)
public class AccountEntryModelPreFilterContributor
	implements ModelPreFilterContributor {

	@Override
	public void contribute(
		BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
		SearchContext searchContext) {

		long[] accountUserIds = (long[])searchContext.getAttribute(
			"accountUserIds");

		if (ArrayUtil.isNotEmpty(accountUserIds)) {
			TermsFilter accountEntryTermsFilter = new TermsFilter(
				"accountUserIds");

			accountEntryTermsFilter.addValues(
				ArrayUtil.toStringArray(accountUserIds));

			booleanFilter.add(accountEntryTermsFilter, BooleanClauseOccur.MUST);
		}

		String[] domains = (String[])searchContext.getAttribute("domains");

		if (ArrayUtil.isNotEmpty(domains)) {
			TermsFilter domainTermsFilter = new TermsFilter("domains");

			domainTermsFilter.addValues(domains);

			booleanFilter.add(domainTermsFilter, BooleanClauseOccur.MUST);
		}

		long parentAccountEntryId = GetterUtil.getLong(
			searchContext.getAttribute("parentAccountEntryId"),
			AccountConstants.ACCOUNT_ENTRY_ID_ANY);

		if (parentAccountEntryId != AccountConstants.ACCOUNT_ENTRY_ID_ANY) {
			booleanFilter.addRequiredTerm(
				"parentAccountEntryId", String.valueOf(parentAccountEntryId));
		}

		int status = GetterUtil.getInteger(
			searchContext.getAttribute("status"),
			WorkflowConstants.STATUS_APPROVED);

		if (status != WorkflowConstants.STATUS_ANY) {
			booleanFilter.addRequiredTerm("status", String.valueOf(status));
		}
	}

}