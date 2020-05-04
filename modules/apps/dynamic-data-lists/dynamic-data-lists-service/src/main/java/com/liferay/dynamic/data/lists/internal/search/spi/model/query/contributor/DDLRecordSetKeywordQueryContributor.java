/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marcela Cunha
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.dynamic.data.lists.model.DDLRecordSet",
	service = KeywordQueryContributor.class
)
public class DDLRecordSetKeywordQueryContributor
	implements KeywordQueryContributor {

	@Override
	public void contribute(
		String keywords, BooleanQuery booleanQuery,
		KeywordQueryContributorHelper keywordQueryContributorHelper) {

		addSearchLocalizedTerm(
			booleanQuery, keywordQueryContributorHelper, Field.DESCRIPTION);
		addSearchLocalizedTerm(
			booleanQuery, keywordQueryContributorHelper, Field.NAME);
	}

	protected void addSearchLocalizedTerm(
		BooleanQuery booleanQuery,
		KeywordQueryContributorHelper keywordQueryContributorHelper,
		String fieldName) {

		SearchContext searchContext =
			keywordQueryContributorHelper.getSearchContext();

		if (Validator.isNull(searchContext.getAttribute(fieldName))) {
			return;
		}

		searchContext.setAttribute(
			LocalizationUtil.getLocalizedName(
				fieldName, searchContext.getLanguageId()),
			searchContext.getAttribute(fieldName));

		queryHelper.addSearchLocalizedTerm(
			booleanQuery, keywordQueryContributorHelper.getSearchContext(),
			fieldName, false);
	}

	@Reference
	protected QueryHelper queryHelper;

}