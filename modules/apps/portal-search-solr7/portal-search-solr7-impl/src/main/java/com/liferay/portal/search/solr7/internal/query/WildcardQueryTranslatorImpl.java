/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.query;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.search.QueryTerm;
import com.liferay.portal.kernel.search.WildcardQuery;

import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BoostQuery;
import org.apache.lucene.search.Query;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 * @author Miguel Angelo Caldas Gallindo
 */
@Component(immediate = true, service = WildcardQueryTranslator.class)
public class WildcardQueryTranslatorImpl implements WildcardQueryTranslator {

	@Override
	public Query translate(WildcardQuery wildcardQuery) {
		QueryTerm queryTerm = wildcardQuery.getQueryTerm();

		Query query = new org.apache.lucene.search.WildcardQuery(
			new Term(queryTerm.getField(), escape(queryTerm.getValue())));

		if (!wildcardQuery.isDefaultBoost()) {
			return new BoostQuery(query, wildcardQuery.getBoost());
		}

		return query;
	}

	protected String escape(String value) {
		int x = 0;
		int y = 0;

		int length = value.length();

		StringBuilder sb = new StringBuilder(length * 2);

		while (y < length) {
			char c = value.charAt(y);

			if ((c == CharPool.QUESTION) || (c == CharPool.SPACE) ||
				(c == CharPool.STAR)) {

				sb.append(QueryParser.escape(value.substring(x, y)));

				if (c == CharPool.SPACE) {
					sb.append(CharPool.BACK_SLASH);
				}

				sb.append(c);

				x = y + 1;
			}

			y++;
		}

		sb.append(QueryParser.escape(value.substring(x)));

		return sb.toString();
	}

}