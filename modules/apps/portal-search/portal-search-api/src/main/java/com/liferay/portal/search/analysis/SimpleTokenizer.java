/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.analysis;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.analysis.Tokenizer;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class SimpleTokenizer implements Tokenizer {

	@Override
	public List<String> tokenize(
		String fieldName, String input, String languageId) {

		return Arrays.asList(StringUtil.split(input, StringPool.PERIOD));
	}

}