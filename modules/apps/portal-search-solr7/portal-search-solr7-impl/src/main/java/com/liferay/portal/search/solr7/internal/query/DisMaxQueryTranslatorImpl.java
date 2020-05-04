/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.query;

import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.generic.DisMaxQuery;
import com.liferay.portal.kernel.search.query.QueryVisitor;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Collection;
import java.util.HashSet;

import org.apache.lucene.search.BoostQuery;
import org.apache.lucene.search.DisjunctionMaxQuery;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = DisMaxQueryTranslator.class)
public class DisMaxQueryTranslatorImpl implements DisMaxQueryTranslator {

	@Override
	public org.apache.lucene.search.Query translate(
		DisMaxQuery disMaxQuery,
		QueryVisitor<org.apache.lucene.search.Query> queryVisitor) {

		Collection<org.apache.lucene.search.Query> queries = new HashSet<>();

		for (Query query : disMaxQuery.getQueries()) {
			queries.add(query.accept(queryVisitor));
		}

		org.apache.lucene.search.Query query = new DisjunctionMaxQuery(
			queries, GetterUtil.getFloat(disMaxQuery.getTieBreaker()));

		if (!disMaxQuery.isDefaultBoost()) {
			return new BoostQuery(query, disMaxQuery.getBoost());
		}

		return query;
	}

}