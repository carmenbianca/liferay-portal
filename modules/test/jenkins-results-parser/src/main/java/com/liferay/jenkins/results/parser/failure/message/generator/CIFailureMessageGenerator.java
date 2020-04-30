/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.failure.message.generator;

import com.liferay.jenkins.results.parser.Dom4JUtil;

import org.dom4j.Element;

/**
 * @author Yi-Chen Tsai
 */
public class CIFailureMessageGenerator extends BaseFailureMessageGenerator {

	@Override
	public Element getMessageElement(String consoleText) {
		int index = consoleText.indexOf(_TOKEN_CI_ERROR);

		if (index == -1) {
			return null;
		}

		String snippet = consoleText.substring(
			index, consoleText.indexOf("\n", index));

		return Dom4JUtil.toCodeSnippetElement(snippet);
	}

	@Override
	public boolean isGenericCIFailure() {
		return true;
	}

	private static final String _TOKEN_CI_ERROR = "A CI failure has occurred.";

}