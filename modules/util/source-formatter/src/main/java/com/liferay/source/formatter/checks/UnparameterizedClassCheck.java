/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class UnparameterizedClassCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		return _fixUnparameterizedClassType(content);
	}

	private String _fixUnparameterizedClassType(String content) {
		Matcher matcher = _unparameterizedClassTypePattern1.matcher(content);

		if (matcher.find()) {
			return StringUtil.replaceFirst(
				content, "Class", "Class<?>", matcher.start());
		}

		matcher = _unparameterizedClassTypePattern2.matcher(content);

		if (matcher.find()) {
			return StringUtil.replaceFirst(
				content, "Class", "Class<?>", matcher.start());
		}

		return content;
	}

	private static final Pattern _unparameterizedClassTypePattern1 =
		Pattern.compile("\\Wnew Class[^<\\w]");
	private static final Pattern _unparameterizedClassTypePattern2 =
		Pattern.compile("\\WClass[\\[\\]]* \\w+ =");

}