/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.query;

import com.liferay.portal.search.query.MatchQuery;
import com.liferay.portal.search.query.Operator;

/**
 * @author Michael C. Han
 */
public abstract class BaseMatchQueryTranslatorImpl {

	protected String translate(
		MatchQuery.RewriteMethod matchQueryRewriteMethod) {

		if (matchQueryRewriteMethod ==
				MatchQuery.RewriteMethod.CONSTANT_SCORE_AUTO) {

			return "constant_score_auto";
		}
		else if (matchQueryRewriteMethod ==
					MatchQuery.RewriteMethod.CONSTANT_SCORE_BOOLEAN) {

			return "constant_score_boolean";
		}
		else if (matchQueryRewriteMethod ==
					MatchQuery.RewriteMethod.CONSTANT_SCORE_FILTER) {

			return "constant_score_filter";
		}
		else if (matchQueryRewriteMethod ==
					MatchQuery.RewriteMethod.SCORING_BOOLEAN) {

			return "scoring_boolean";
		}
		else if (matchQueryRewriteMethod ==
					MatchQuery.RewriteMethod.TOP_TERMS_N) {

			return "top_terms_N";
		}
		else if (matchQueryRewriteMethod ==
					MatchQuery.RewriteMethod.TOP_TERMS_BOOST_N) {

			return "top_terms_boost_N";
		}

		throw new IllegalArgumentException(
			"Invalid rewrite method: " + matchQueryRewriteMethod);
	}

	protected org.elasticsearch.index.search.MatchQuery.ZeroTermsQuery
		translate(MatchQuery.ZeroTermsQuery matchQueryZeroTermsQuery) {

		if (matchQueryZeroTermsQuery == MatchQuery.ZeroTermsQuery.ALL) {
			return org.elasticsearch.index.search.MatchQuery.ZeroTermsQuery.ALL;
		}
		else if (matchQueryZeroTermsQuery == MatchQuery.ZeroTermsQuery.NONE) {
			return org.elasticsearch.index.search.MatchQuery.ZeroTermsQuery.
				NONE;
		}

		throw new IllegalArgumentException(
			"Invalid zero terms query: " + matchQueryZeroTermsQuery);
	}

	protected org.elasticsearch.index.query.Operator translate(
		Operator matchQueryOperator) {

		if (matchQueryOperator == Operator.AND) {
			return org.elasticsearch.index.query.Operator.AND;
		}
		else if (matchQueryOperator == Operator.OR) {
			return org.elasticsearch.index.query.Operator.AND;
		}

		throw new IllegalArgumentException(
			"Invalid operator: " + matchQueryOperator);
	}

}