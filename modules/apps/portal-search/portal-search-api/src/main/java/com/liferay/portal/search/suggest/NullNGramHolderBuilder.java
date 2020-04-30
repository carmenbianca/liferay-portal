/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.suggest;

import com.liferay.portal.kernel.search.suggest.NGramHolder;
import com.liferay.portal.kernel.search.suggest.NGramHolderBuilder;

/**
 * @author Michael C. Han
 */
public class NullNGramHolderBuilder implements NGramHolderBuilder {

	@Override
	public NGramHolder buildNGramHolder(String input) {
		return new NGramHolder();
	}

	@Override
	public NGramHolder buildNGramHolder(String input, int nGramMaxLength) {
		return new NGramHolder();
	}

	@Override
	public NGramHolder buildNGramHolder(
		String input, int nGramMinLength, int nGramMaxLength) {

		return new NGramHolder();
	}

}