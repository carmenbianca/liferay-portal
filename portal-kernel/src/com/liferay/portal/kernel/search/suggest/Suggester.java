/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.suggest;

/**
 * @author Michael C. Han
 */
public interface Suggester {

	public <T> T accept(SuggesterVisitor<T> suggesterVisitor);

	public String getName();

	public enum Sort {

		FREQUENCY, SCORE

	}

	public enum StringDistance {

		DAMERAU_LEVENSHTEIN, INTERNAL, JAROWINKLER, LEVENSTEIN, NGRAM

	}

	public enum SuggestMode {

		ALWAYS, MISSING, POPULAR

	}

}