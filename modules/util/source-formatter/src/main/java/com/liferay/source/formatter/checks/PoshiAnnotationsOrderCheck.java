/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alan Huang
 */
public class PoshiAnnotationsOrderCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		Matcher matcher = _annotationsPattern.matcher(content);

		while (matcher.find()) {
			String match = matcher.group();

			String[] annotations = match.split("\n");

			Arrays.sort(annotations);

			StringBundler sb = new StringBundler(annotations.length * 2);

			for (String annotation : annotations) {
				sb.append(annotation);
				sb.append("\n");
			}

			String sortedAnnotations = sb.toString();

			if (!StringUtil.equals(match, sortedAnnotations)) {
				content = StringUtil.replaceFirst(
					content, match, sortedAnnotations, matcher.start());
			}
		}

		return content;
	}

	private static final Pattern _annotationsPattern = Pattern.compile(
		"(^\t*)(@.+?=.+?\n)(\\1(@.+?=.+?\n))+", Pattern.MULTILINE);

}