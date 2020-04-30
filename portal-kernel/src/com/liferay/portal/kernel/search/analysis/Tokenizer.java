/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.analysis;

import com.liferay.portal.kernel.search.SearchException;

import java.util.List;

/**
 * @author David Mendez Gonzalez
 */
public interface Tokenizer {

	public List<String> tokenize(
			String fieldName, String input, String languageId)
		throws SearchException;

}