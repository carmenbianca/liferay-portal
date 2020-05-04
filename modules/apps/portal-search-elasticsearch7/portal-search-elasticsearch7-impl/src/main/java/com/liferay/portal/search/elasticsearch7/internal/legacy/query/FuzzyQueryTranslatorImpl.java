/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.legacy.query;

import com.liferay.portal.kernel.search.generic.FuzzyQuery;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = FuzzyQueryTranslator.class)
public class FuzzyQueryTranslatorImpl implements FuzzyQueryTranslator {

	@Override
	public QueryBuilder translate(FuzzyQuery fuzzyQuery) {
		FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery(
			fuzzyQuery.getField(), fuzzyQuery.getValue());

		if (fuzzyQuery.getFuzziness() != null) {
			fuzzyQueryBuilder.fuzziness(
				Fuzziness.build(fuzzyQuery.getFuzziness()));
		}

		if (fuzzyQuery.getMaxExpansions() != null) {
			fuzzyQueryBuilder.maxExpansions(fuzzyQuery.getMaxExpansions());
		}

		if (fuzzyQuery.getPrefixLength() != null) {
			fuzzyQueryBuilder.prefixLength(fuzzyQuery.getPrefixLength());
		}

		if (!fuzzyQuery.isDefaultBoost()) {
			fuzzyQueryBuilder.boost(fuzzyQuery.getBoost());
		}

		return fuzzyQueryBuilder;
	}

}