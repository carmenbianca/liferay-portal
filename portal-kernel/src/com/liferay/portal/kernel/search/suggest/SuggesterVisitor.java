/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.suggest;

/**
 * @author Michael C. Han
 */
public interface SuggesterVisitor<T> {

	/**
	 * @deprecated As of Mueller (7.2.x), with no direct replacement
	 */
	@Deprecated
	public T visit(AggregateSuggester aggregateSuggester);

	public T visit(CompletionSuggester completionSuggester);

	public T visit(PhraseSuggester phraseSuggester);

	public T visit(TermSuggester termSuggester);

}