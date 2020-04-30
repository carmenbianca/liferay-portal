/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JSStylingCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		if (content.contains("debugger.")) {
			addMessage(fileName, "Do not use debugger");
		}

		return _formatMultipleVarsOnSingleLine(content);
	}

	private String _formatMultipleVarsOnSingleLine(String content) {
		while (true) {
			Matcher matcher = _multipleVarsOnSingleLinePattern.matcher(content);

			if (!matcher.find()) {
				break;
			}

			String match = matcher.group();

			int pos = match.indexOf("var ");

			StringBundler sb = new StringBundler(4);

			sb.append(match.substring(0, match.length() - 2));
			sb.append(StringPool.SEMICOLON);
			sb.append("\n");
			sb.append(match.substring(0, pos + 4));

			content = StringUtil.replace(content, match, sb.toString());
		}

		return content;
	}

	private static final Pattern _multipleVarsOnSingleLinePattern =
		Pattern.compile("\t+var \\w+\\, ");

}