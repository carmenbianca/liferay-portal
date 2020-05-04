/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.suggest;

import com.liferay.portal.kernel.search.suggest.CompletionSuggester;
import com.liferay.portal.kernel.util.Validator;

import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.SuggestionBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = CompletionSuggesterTranslator.class)
public class CompletionSuggesterTranslatorImpl
	implements CompletionSuggesterTranslator {

	@Override
	public SuggestionBuilder translate(
		CompletionSuggester completionSuggester) {

		CompletionSuggestionBuilder completionSuggesterBuilder =
			SuggestBuilders.completionSuggestion(
				completionSuggester.getField());

		if (Validator.isNotNull(completionSuggester.getAnalyzer())) {
			completionSuggesterBuilder.analyzer(
				completionSuggester.getAnalyzer());
		}

		if (completionSuggester.getShardSize() != null) {
			completionSuggesterBuilder.shardSize(
				completionSuggester.getShardSize());
		}

		if (completionSuggester.getSize() != null) {
			completionSuggesterBuilder.size(completionSuggester.getSize());
		}

		completionSuggesterBuilder.text(completionSuggester.getValue());

		return completionSuggesterBuilder;
	}

}