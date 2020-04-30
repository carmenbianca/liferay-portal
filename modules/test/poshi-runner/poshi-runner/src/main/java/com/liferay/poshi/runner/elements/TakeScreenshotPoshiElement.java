/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.elements;

import com.liferay.poshi.runner.script.PoshiScriptParserException;

import java.util.List;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.Node;

/**
 * @author Kenji Heigel
 */
public class TakeScreenshotPoshiElement extends PoshiElement {

	@Override
	public PoshiElement clone(Element element) {
		if (isElementType(_ELEMENT_NAME, element)) {
			return new TakeScreenshotPoshiElement(element);
		}

		return null;
	}

	@Override
	public PoshiElement clone(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		if (_isElementType(poshiScript)) {
			return new TakeScreenshotPoshiElement(
				parentPoshiElement, poshiScript);
		}

		return null;
	}

	@Override
	public void parsePoshiScript(String poshiScript)
		throws PoshiScriptParserException {
	}

	@Override
	public String toPoshiScript() {
		String poshiScript = super.toPoshiScript();

		return createPoshiScriptSnippet(poshiScript);
	}

	protected TakeScreenshotPoshiElement() {
	}

	protected TakeScreenshotPoshiElement(Element element) {
		super(_ELEMENT_NAME, element);
	}

	protected TakeScreenshotPoshiElement(
		List<Attribute> attributes, List<Node> nodes) {

		super(_ELEMENT_NAME, attributes, nodes);
	}

	protected TakeScreenshotPoshiElement(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		super(_ELEMENT_NAME, parentPoshiElement, poshiScript);
	}

	@Override
	protected String createPoshiScriptSnippet(String content) {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\n");
		sb.append(getPad());
		sb.append(getBlockName());
		sb.append("();");

		return sb.toString();
	}

	@Override
	protected String getBlockName() {
		return _POSHI_SCRIPT_KEYWORD;
	}

	private boolean _isElementType(String poshiScript) {
		return isValidPoshiScriptStatement(_statementPattern, poshiScript);
	}

	private static final String _ELEMENT_NAME = "take-screenshot";

	private static final String _POSHI_SCRIPT_KEYWORD = "takeScreenshot";

	private static final Pattern _statementPattern = Pattern.compile(
		"^" + _POSHI_SCRIPT_KEYWORD + PARAMETER_REGEX + STATEMENT_END_REGEX);

}