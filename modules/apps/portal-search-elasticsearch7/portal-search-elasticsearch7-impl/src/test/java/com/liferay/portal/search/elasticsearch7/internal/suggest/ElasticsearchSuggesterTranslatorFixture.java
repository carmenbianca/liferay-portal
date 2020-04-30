/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.suggest;

/**
 * @author Michael C. Han
 */
public class ElasticsearchSuggesterTranslatorFixture {

	public ElasticsearchSuggesterTranslatorFixture() {
		_elasticsearchSuggesterTranslator =
			new ElasticsearchSuggesterTranslator() {
				{
					setCompletionSuggesterTranslator(
						new CompletionSuggesterTranslatorImpl());

					setPhraseSuggesterTranslator(
						new PhraseSuggesterTranslatorImpl());

					setTermSuggesterTranslator(
						new TermSuggesterTranslatorImpl());
				}
			};
	}

	public ElasticsearchSuggesterTranslator
		getElasticsearchSuggesterTranslator() {

		return _elasticsearchSuggesterTranslator;
	}

	private final ElasticsearchSuggesterTranslator
		_elasticsearchSuggesterTranslator;

}