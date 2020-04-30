/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.checks.util.JSPSourceUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JSPLanguageUtilCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		Matcher matcher = _languageUtilPattern.matcher(content);

		while (matcher.find()) {
			if (JSPSourceUtil.isJavaSource(content, matcher.start(), true)) {
				return StringUtil.replaceFirst(
					content, "LanguageUtil.get(locale,",
					"LanguageUtil.get(request,");
			}
		}

		return content;
	}

	private static final Pattern _languageUtilPattern = Pattern.compile(
		"LanguageUtil\\.get\\(locale,");

}