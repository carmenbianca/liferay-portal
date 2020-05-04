/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.filter;

import com.liferay.portal.kernel.search.filter.ExistsFilter;

import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermRangeQuery;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = ExistsFilterTranslator.class)
public class ExistsFilterTranslatorImpl implements ExistsFilterTranslator {

	@Override
	public Query translate(ExistsFilter existsFilter) {
		BooleanQuery.Builder builder = new BooleanQuery.Builder();

		builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);

		builder.add(
			TermRangeQuery.newStringRange(
				existsFilter.getField(), "*", "*", true, true),
			BooleanClause.Occur.MUST);

		return builder.build();
	}

}