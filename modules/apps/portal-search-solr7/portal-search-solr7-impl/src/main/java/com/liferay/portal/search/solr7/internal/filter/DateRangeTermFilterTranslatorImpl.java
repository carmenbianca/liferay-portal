/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.filter;

import com.liferay.portal.kernel.search.filter.DateRangeTermFilter;

import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermRangeQuery;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = DateRangeTermFilterTranslator.class)
public class DateRangeTermFilterTranslatorImpl
	implements DateRangeTermFilterTranslator {

	@Override
	public Query translate(DateRangeTermFilter dateRangeTermFilter) {
		return TermRangeQuery.newStringRange(
			dateRangeTermFilter.getField(), dateRangeTermFilter.getLowerBound(),
			dateRangeTermFilter.getUpperBound(),
			dateRangeTermFilter.isIncludesLower(),
			dateRangeTermFilter.isIncludesUpper());
	}

}