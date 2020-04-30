/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.query.translator;

import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.query.TermQuery;

/**
 * @author André de Oliveira
 */
public class SolrQueryTranslator {

	public org.apache.lucene.search.Query convert(Query query) {
		if (query instanceof BooleanQuery) {
			return visit((BooleanQuery)query);
		}

		if (query instanceof TermQuery) {
			return visit((TermQuery)query);
		}

		return null;
	}

	public String translate(Query query) {
		org.apache.lucene.search.Query luceneQuery = convert(query);

		if (luceneQuery != null) {
			return luceneQuery.toString();
		}

		return null;
	}

	public org.apache.lucene.search.Query visit(BooleanQuery booleanQuery) {
		BooleanQueryTranslatorImpl booleanQueryTranslatorImpl =
			new BooleanQueryTranslatorImpl();

		return booleanQueryTranslatorImpl.translate(booleanQuery, this);
	}

	public org.apache.lucene.search.Query visit(TermQuery termQuery) {
		TermQueryTranslatorImpl termQueryTranslatorImpl =
			new TermQueryTranslatorImpl();

		return termQueryTranslatorImpl.translate(termQuery);
	}

}