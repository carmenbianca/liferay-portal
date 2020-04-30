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
public class JSPServiceUtilCheck extends BaseFileCheck {

	@Override
	public boolean isModuleSourceCheck() {
		return true;
	}

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		Matcher matcher = _serviceUtilPattern.matcher(content);

		if (matcher.find()) {
			addMessage(
				fileName, "Do not use *ServiceUtil in module jsp",
				getLineNumber(content, matcher.start()));
		}

		return content;
	}

	private static final Pattern _serviceUtilPattern = Pattern.compile(
		"\\b[A-Z]\\w+ServiceUtil\\.");

}