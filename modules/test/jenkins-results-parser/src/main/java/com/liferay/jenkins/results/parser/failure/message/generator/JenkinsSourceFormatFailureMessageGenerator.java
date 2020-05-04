/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.failure.message.generator;

import org.dom4j.Element;

/**
 * @author Yi-Chen Tsai
 */
public class JenkinsSourceFormatFailureMessageGenerator
	extends BaseFailureMessageGenerator {

	@Override
	public Element getMessageElement(String consoleText) {
		if (!consoleText.contains(_TOKEN_PLEASE_RUN_FORMAT_SOURCE)) {
			return null;
		}

		int start = consoleText.lastIndexOf(_TOKEN_PLEASE_RUN_FORMAT_SOURCE);

		start = consoleText.lastIndexOf("\n", start);

		return getConsoleTextSnippetElementByStart(consoleText, start);
	}

	private static final String _TOKEN_PLEASE_RUN_FORMAT_SOURCE =
		"Please run format source and resubmit after fixing these files:";

}