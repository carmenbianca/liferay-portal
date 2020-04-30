/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JSPFunctionNameCheck extends BaseFileCheck {

	@Override
	public boolean isLiferaySourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		Matcher matcher = _functionPattern.matcher(content);

		while (matcher.find()) {
			String functionName = matcher.group(2);

			if (!functionName.matches(_FUNCTION_NAME_REGEX)) {
				addMessage(
					fileName,
					StringBundler.concat(
						"Function '", functionName, "' much match pattern '",
						_FUNCTION_NAME_REGEX, "'"),
					getLineNumber(content, matcher.start(2)));
			}
		}

		return content;
	}

	private static final String _FUNCTION_NAME_REGEX =
		"^[a-z0-9][_a-zA-Z0-9]*$";

	private static final Pattern _functionPattern = Pattern.compile(
		"[\n\t]function (<.*>)?(\\w+)\\(");

}