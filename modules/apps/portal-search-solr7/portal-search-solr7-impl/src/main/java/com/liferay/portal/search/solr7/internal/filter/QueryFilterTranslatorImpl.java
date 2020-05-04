/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.filter;

import com.liferay.portal.kernel.search.filter.QueryFilter;
import com.liferay.portal.search.solr7.internal.query.LuceneQueryConverter;

import org.apache.lucene.search.Query;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = QueryFilterTranslator.class)
public class QueryFilterTranslatorImpl implements QueryFilterTranslator {

	@Override
	public Query translate(QueryFilter queryFilter) {
		return _luceneQueryConverter.convert(queryFilter.getQuery());
	}

	@Reference(unbind = "-")
	protected void setLuceneQueryConverter(
		LuceneQueryConverter luceneQueryConverter) {

		_luceneQueryConverter = luceneQueryConverter;
	}

	private LuceneQueryConverter _luceneQueryConverter;

}