/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.legacy.query;

import com.liferay.portal.search.elasticsearch6.internal.filter.ElasticsearchFilterTranslatorFixture;

/**
 * @author Michael C. Han
 */
public class ElasticsearchQueryTranslatorFixture {

	public ElasticsearchQueryTranslatorFixture() {
		_elasticsearchQueryTranslator = new ElasticsearchQueryTranslator() {
			{
				booleanQueryTranslator = new BooleanQueryTranslatorImpl() {
					{
						ElasticsearchFilterTranslatorFixture
							elasticsearchFilterTranslatorFixture =
								new ElasticsearchFilterTranslatorFixture();

						filterTranslator =
							elasticsearchFilterTranslatorFixture.
								getElasticsearchFilterTranslator();
					}
				};

				disMaxQueryTranslator = new DisMaxQueryTranslatorImpl();
				fuzzyQueryTranslator = new FuzzyQueryTranslatorImpl();
				matchAllQueryTranslator = new MatchAllQueryTranslatorImpl();
				matchQueryTranslator = new MatchQueryTranslatorImpl();
				moreLikeThisQueryTranslator =
					new MoreLikeThisQueryTranslatorImpl();
				multiMatchQueryTranslator = new MultiMatchQueryTranslatorImpl();
				nestedQueryTranslator = new NestedQueryTranslatorImpl();
				stringQueryTranslator = new StringQueryTranslatorImpl();
				termQueryTranslator = new TermQueryTranslatorImpl();
				termRangeQueryTranslator = new TermRangeQueryTranslatorImpl();
				wildcardQueryTranslator = new WildcardQueryTranslatorImpl();
			}
		};
	}

	public ElasticsearchQueryTranslator getElasticsearchQueryTranslator() {
		return _elasticsearchQueryTranslator;
	}

	private final ElasticsearchQueryTranslator _elasticsearchQueryTranslator;

}