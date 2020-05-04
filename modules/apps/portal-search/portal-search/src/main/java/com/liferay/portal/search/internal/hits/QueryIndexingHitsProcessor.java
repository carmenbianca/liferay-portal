/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.hits;

import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.hits.HitsProcessor;
import com.liferay.portal.kernel.search.suggest.SuggestionConstants;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 * @author Josef Sustacek
 */
@Component(
	immediate = true, property = "sort.order=2", service = HitsProcessor.class
)
public class QueryIndexingHitsProcessor implements HitsProcessor {

	@Override
	public boolean process(SearchContext searchContext, Hits hits)
		throws SearchException {

		QueryConfig queryConfig = searchContext.getQueryConfig();

		if (!queryConfig.isQueryIndexingEnabled()) {
			return true;
		}

		if (hits.getLength() >= queryConfig.getQueryIndexingThreshold()) {
			addDocument(
				searchContext.getCompanyId(), searchContext.getKeywords(),
				searchContext.getLocale());
		}

		return true;
	}

	protected void addDocument(long companyId, String keywords, Locale locale)
		throws SearchException {

		indexWriterHelper.indexKeyword(
			companyId, keywords, 0, SuggestionConstants.TYPE_QUERY_SUGGESTION,
			locale);
	}

	@Reference
	protected IndexWriterHelper indexWriterHelper;

}