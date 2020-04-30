/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.source.formatter.checks.util.SourceUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Shin
 */
public class PropertiesCommentsCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		return _formatComments(content);
	}

	private String _formatComments(String content) {
		Matcher matcher = _commentPattern.matcher(content);

		while (matcher.find()) {
			if ((matcher.group(1) != null) || (matcher.group(3) != null)) {
				continue;
			}

			String comment = matcher.group(2);

			String titleCaseComment = SourceUtil.getTitleCase(
				comment, true, _BRAND_NAMES);

			titleCaseComment = titleCaseComment.replaceAll(
				"(?i)(\\A|\\s)sf(\\Z|\\s)", "$1Source Formatter$2");

			if (!titleCaseComment.equals(comment)) {
				return StringUtil.replaceFirst(
					content, comment, titleCaseComment, matcher.start(2));
			}
		}

		return content;
	}

	private static final String[] _BRAND_NAMES = {
		"jQuery", "reCAPTCHA", "svg4everybody", "tc"
	};

	private static final Pattern _commentPattern = Pattern.compile(
		"([^#]\\s*)?\\n\\s*#+\\s+(\\w[\\s\\w]+)(\\n\\s*#+.*[\\w]+.*)?$",
		Pattern.MULTILINE);

}