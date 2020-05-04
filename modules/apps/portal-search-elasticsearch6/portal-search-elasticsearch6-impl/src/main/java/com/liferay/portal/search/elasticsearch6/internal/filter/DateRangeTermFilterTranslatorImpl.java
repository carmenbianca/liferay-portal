/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.filter;

import com.liferay.portal.kernel.search.filter.DateRangeTermFilter;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;

import java.text.Format;
import java.text.ParseException;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = DateRangeTermFilterTranslator.class)
public class DateRangeTermFilterTranslatorImpl
	implements DateRangeTermFilterTranslator {

	@Override
	public QueryBuilder translate(DateRangeTermFilter dateRangeTermFilter) {
		RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery(
			dateRangeTermFilter.getField());

		Format format = FastDateFormatFactoryUtil.getSimpleDateFormat(
			dateRangeTermFilter.getDateFormat(),
			dateRangeTermFilter.getTimeZone());

		try {
			rangeQueryBuilder.from(
				format.parseObject(dateRangeTermFilter.getLowerBound()));
			rangeQueryBuilder.includeLower(
				dateRangeTermFilter.isIncludesLower());
			rangeQueryBuilder.includeUpper(
				dateRangeTermFilter.isIncludesUpper());
			rangeQueryBuilder.to(
				format.parseObject(dateRangeTermFilter.getUpperBound()));
		}
		catch (ParseException parseException) {
			throw new IllegalArgumentException(
				"Invalid date range " + dateRangeTermFilter, parseException);
		}

		return rangeQueryBuilder;
	}

}