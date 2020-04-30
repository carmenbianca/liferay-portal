/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JavaSessionCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		Matcher matcher = _flushClearPattern.matcher(content);

		return matcher.replaceAll("$1\n$4");
	}

	private static final Pattern _flushClearPattern = Pattern.compile(
		"(\t((\\w*)[sS]ession)\\.flush\\(\\);\n)(\t+\\2\\.clear\\(\\);\n)");

}