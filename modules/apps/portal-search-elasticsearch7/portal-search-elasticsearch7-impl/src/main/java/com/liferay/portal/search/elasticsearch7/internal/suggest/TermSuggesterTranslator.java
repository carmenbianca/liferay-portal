/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.suggest;

import com.liferay.portal.kernel.search.suggest.TermSuggester;

import org.elasticsearch.search.suggest.SuggestionBuilder;

/**
 * @author Michael C. Han
 */
public interface TermSuggesterTranslator {

	public SuggestionBuilder translate(TermSuggester termSuggester);

}