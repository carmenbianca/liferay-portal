/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JSPTaglibVariableCheck extends BaseJSPTermsCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		return _formatTaglibVariable(fileName, content);
	}

	private String _formatTaglibVariable(String fileName, String content)
		throws IOException {

		Matcher matcher = _taglibVariablePattern.matcher(content);

		while (matcher.find()) {
			String nextTag = matcher.group(4);
			String taglibValue = matcher.group(3);
			String variableName = matcher.group(2);

			if (taglibValue.contains("\\\"") ||
				(taglibValue.contains(StringPool.APOSTROPHE) &&
				 taglibValue.contains(StringPool.QUOTE))) {

				if (!variableName.startsWith("taglib") &&
					(StringUtil.count(content, variableName) == 2) &&
					nextTag.contains("=\"<%= " + variableName + " %>\"")) {

					addMessage(
						fileName,
						"Variable '" + variableName +
							"' should start with 'taglib'",
						getLineNumber(content, matcher.start()));
				}

				continue;
			}

			if (nextTag.contains("=\"<%= " + variableName + " %>\"")) {
				populateContentsMap(fileName, content);

				String newContent = StringUtil.replaceFirst(
					content, variableName, taglibValue, matcher.start(4));

				Set<String> checkedFileNames = new HashSet<>();
				Set<String> includeFileNames = new HashSet<>();

				if (hasUnusedJSPTerm(
						fileName, newContent, "\\W" + variableName + "\\W",
						"variable", checkedFileNames, includeFileNames,
						getContentsMap())) {

					return StringUtil.replaceFirst(
						newContent, matcher.group(1), StringPool.BLANK,
						matcher.start());
				}
			}
		}

		return content;
	}

	private static final Pattern _taglibVariablePattern = Pattern.compile(
		"(\t*String (\\w+) = (.*);)\n\\s*%>\\s+(<[\\S\\s]*?>)\n");

}