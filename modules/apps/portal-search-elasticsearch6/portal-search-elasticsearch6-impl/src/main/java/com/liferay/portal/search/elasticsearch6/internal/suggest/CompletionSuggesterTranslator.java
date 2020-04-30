/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.suggest;

import com.liferay.portal.kernel.search.suggest.CompletionSuggester;

import org.elasticsearch.search.suggest.SuggestionBuilder;

/**
 * @author Michael C. Han
 */
public interface CompletionSuggesterTranslator {

	public SuggestionBuilder translate(CompletionSuggester completionSuggester);

}