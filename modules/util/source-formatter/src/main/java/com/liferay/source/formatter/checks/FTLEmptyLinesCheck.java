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
public class FTLEmptyLinesCheck extends BaseEmptyLinesCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		content = fixEmptyLinesInMultiLineTags(content);

		content = fixEmptyLinesInNestedTags(content);

		content = fixEmptyLinesBetweenTags(content);

		content = _fixMissingEmptyLinesAroundComments(content);

		return content;
	}

	private String _fixMissingEmptyLinesAroundComments(String content) {
		Matcher matcher = _missingEmptyLineAfterCommentPattern.matcher(content);

		if (matcher.find()) {
			return StringUtil.replaceFirst(
				content, "\n", "\n\n", matcher.start());
		}

		matcher = _missingEmptyLineBeforeCommentPattern.matcher(content);

		if (matcher.find()) {
			return StringUtil.replaceFirst(
				content, "\n", "\n\n", matcher.start());
		}

		return content;
	}

	private static final Pattern _missingEmptyLineAfterCommentPattern =
		Pattern.compile("-->\n[^\n]");
	private static final Pattern _missingEmptyLineBeforeCommentPattern =
		Pattern.compile("[^\n]\n\t*<#--");

}