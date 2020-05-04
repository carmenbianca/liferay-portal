/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.suggest;

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.suggest.AggregateSuggester;
import com.liferay.portal.kernel.search.suggest.CompletionSuggester;
import com.liferay.portal.kernel.search.suggest.PhraseSuggester;
import com.liferay.portal.kernel.search.suggest.Suggester;
import com.liferay.portal.kernel.search.suggest.SuggesterTranslator;
import com.liferay.portal.kernel.search.suggest.SuggesterVisitor;
import com.liferay.portal.kernel.search.suggest.TermSuggester;

import org.elasticsearch.search.suggest.SuggestionBuilder;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "search.engine.impl=Elasticsearch",
	service = SuggesterTranslator.class
)
public class ElasticsearchSuggesterTranslator
	implements SuggesterTranslator<SuggestionBuilder>,
			   SuggesterVisitor<SuggestionBuilder> {

	@Override
	public SuggestionBuilder translate(
		Suggester suggester, SearchContext searchContext) {

		return suggester.accept(this);
	}

	@Override
	public SuggestionBuilder visit(AggregateSuggester aggregateSuggester) {
		return null;
	}

	@Override
	public SuggestionBuilder visit(CompletionSuggester completionSuggester) {
		return _completionSuggesterTranslator.translate(completionSuggester);
	}

	@Override
	public SuggestionBuilder visit(PhraseSuggester phraseSuggester) {
		return _phraseSuggesterTranslator.translate(phraseSuggester);
	}

	@Override
	public SuggestionBuilder visit(TermSuggester termSuggester) {
		return _termSuggesterTranslator.translate(termSuggester);
	}

	@Reference(unbind = "-")
	protected void setCompletionSuggesterTranslator(
		CompletionSuggesterTranslator completionSuggesterTranslator) {

		_completionSuggesterTranslator = completionSuggesterTranslator;
	}

	@Reference(unbind = "-")
	protected void setPhraseSuggesterTranslator(
		PhraseSuggesterTranslator phraseSuggesterTranslator) {

		_phraseSuggesterTranslator = phraseSuggesterTranslator;
	}

	@Reference(unbind = "-")
	protected void setTermSuggesterTranslator(
		TermSuggesterTranslator termSuggesterTranslator) {

		_termSuggesterTranslator = termSuggesterTranslator;
	}

	private CompletionSuggesterTranslator _completionSuggesterTranslator;
	private PhraseSuggesterTranslator _phraseSuggesterTranslator;
	private TermSuggesterTranslator _termSuggesterTranslator;

}