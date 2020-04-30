/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.failure.message.generator;

import com.liferay.jenkins.results.parser.Dom4JUtil;

import org.dom4j.Element;

/**
 * @author Yi-Chen Tsai
 */
public class StartupFailureMessageGenerator
	extends BaseFailureMessageGenerator {

	@Override
	public Element getMessageElement(String consoleText) {
		if (!consoleText.contains(_TOKEN_UNRESOLVED_REQUIREMENT)) {
			return null;
		}

		int start = consoleText.indexOf(_TOKEN_UNRESOLVED_REQUIREMENT);

		start = consoleText.lastIndexOf(_TOKEN_COULD_NOT_RESOLVE_MODULE, start);

		start = consoleText.lastIndexOf("\n", start);

		int end = consoleText.indexOf(_TOKEN_DELETING, start);

		end = consoleText.lastIndexOf("\n", end);

		return Dom4JUtil.getNewElement(
			"div", null,
			Dom4JUtil.getNewElement(
				"p", null, "Startup error: ",
				Dom4JUtil.getNewElement(
					"strong", null, "Unresolved Requirement(s)")),
			getConsoleTextSnippetElement(consoleText, true, start, end));
	}

	private static final String _TOKEN_COULD_NOT_RESOLVE_MODULE =
		"Could not resolve module:";

	private static final String _TOKEN_DELETING = "Deleting:";

	private static final String _TOKEN_UNRESOLVED_REQUIREMENT =
		"Unresolved requirement:";

}