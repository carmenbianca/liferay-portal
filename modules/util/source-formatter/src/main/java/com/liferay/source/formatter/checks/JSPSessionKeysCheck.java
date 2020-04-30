/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JSPSessionKeysCheck extends SessionKeysCheck {

	@Override
	protected List<Pattern> getPatterns() {
		return Arrays.asList(sessionKeyPattern, _taglibSessionKeyPattern);
	}

	private static final Pattern _taglibSessionKeyPattern = Pattern.compile(
		"<liferay-ui:error [^>]+>|<liferay-ui:success [^>]+>",
		Pattern.MULTILINE);

}