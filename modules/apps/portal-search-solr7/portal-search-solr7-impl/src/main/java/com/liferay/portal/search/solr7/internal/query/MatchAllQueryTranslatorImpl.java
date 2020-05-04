/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.query;

import com.liferay.portal.kernel.search.generic.MatchAllQuery;

import org.apache.lucene.search.BoostQuery;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = MatchAllQueryTranslator.class)
public class MatchAllQueryTranslatorImpl implements MatchAllQueryTranslator {

	@Override
	public Query translate(MatchAllQuery matchAllQuery) {
		Query query = new MatchAllDocsQuery();

		if (!matchAllQuery.isDefaultBoost()) {
			return new BoostQuery(query, matchAllQuery.getBoost());
		}

		return query;
	}

}