/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.failure.message.generator;

import com.liferay.jenkins.results.parser.Dom4JUtil;

import org.dom4j.Element;

/**
 * @author Kevin Yen
 */
public class DownstreamFailureMessageGenerator
	extends BaseFailureMessageGenerator {

	@Override
	public Element getMessageElement(String consoleText) {
		if (consoleText.contains("Downstream jobs FAILED.")) {
			return Dom4JUtil.toCodeSnippetElement("Downstream jobs FAILED.");
		}

		return null;
	}

}