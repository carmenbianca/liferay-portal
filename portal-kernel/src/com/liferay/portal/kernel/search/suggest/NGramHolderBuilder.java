/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.suggest;

import com.liferay.portal.kernel.search.SearchException;

/**
 * @author Michael C. Han
 */
public interface NGramHolderBuilder {

	public NGramHolder buildNGramHolder(String input) throws SearchException;

	public NGramHolder buildNGramHolder(String input, int nGramMaxLength)
		throws SearchException;

	public NGramHolder buildNGramHolder(
			String input, int nGramMinLength, int nGramMaxLength)
		throws SearchException;

}