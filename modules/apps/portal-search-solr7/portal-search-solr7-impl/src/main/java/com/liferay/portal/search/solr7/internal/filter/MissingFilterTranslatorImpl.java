/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.filter;

import com.liferay.portal.kernel.search.filter.MissingFilter;

import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermRangeQuery;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = MissingFilterTranslator.class)
public class MissingFilterTranslatorImpl implements MissingFilterTranslator {

	@Override
	public Query translate(MissingFilter missingFilter) {
		BooleanQuery.Builder builder = new BooleanQuery.Builder();

		builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);

		builder.add(
			TermRangeQuery.newStringRange(
				missingFilter.getField(), "*", "*", true, true),
			BooleanClause.Occur.MUST_NOT);

		return builder.build();
	}

}