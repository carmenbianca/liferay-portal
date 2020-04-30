/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.elements;

import com.liferay.poshi.runner.script.PoshiScriptParserException;
import com.liferay.poshi.runner.util.RegexUtil;
import com.liferay.poshi.runner.util.StringUtil;

import java.util.List;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.Node;

/**
 * @author Kenji Heigel
 */
public class ReturnPoshiElement extends PoshiElement {

	@Override
	public PoshiElement clone(Element element) {
		if (isElementType(_ELEMENT_NAME, element)) {
			return new ReturnPoshiElement(element);
		}

		return null;
	}

	@Override
	public PoshiElement clone(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		if (_isElementType(parentPoshiElement, poshiScript)) {
			return new ReturnPoshiElement(parentPoshiElement, poshiScript);
		}

		return null;
	}

	@Override
	public void parsePoshiScript(String poshiScript)
		throws PoshiScriptParserException {

		if (getParent() instanceof ExecutePoshiElement) {
			String returnName = RegexUtil.getGroup(
				poshiScript, "var\\s*(.+?)\\s*=", 1);

			addAttribute("name", returnName);

			return;
		}

		addAttribute("value", getDoubleQuotedContent(poshiScript));
	}

	@Override
	public String toPoshiScript() {
		if (getParent() instanceof ExecutePoshiElement) {
			return "";
		}

		return StringUtil.combine(
			"\n\n", getPad(), "return \"", attributeValue("value"), "\";");
	}

	@Override
	public void validatePoshiScript() throws PoshiScriptParserException {
	}

	protected ReturnPoshiElement() {
	}

	protected ReturnPoshiElement(Element element) {
		super(_ELEMENT_NAME, element);
	}

	protected ReturnPoshiElement(List<Attribute> attributes, List<Node> nodes) {
		super(_ELEMENT_NAME, attributes, nodes);
	}

	protected ReturnPoshiElement(
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
		sb.append(content.trim());

		return sb.toString();
	}

	@Override
	protected String getBlockName() {
		StringBuilder sb = new StringBuilder();

		sb.append("var ");
		sb.append(attributeValue("name"));
		sb.append(" = ");

		return sb.toString();
	}

	private boolean _isElementType(
		PoshiElement parentPoshiElement, String poshiScript) {

		poshiScript = poshiScript.trim();

		if (parentPoshiElement instanceof ExecutePoshiElement) {
			if (!poshiScript.startsWith("var")) {
				return false;
			}

			if (isVarAssignedToMacroInvocation(poshiScript)) {
				return true;
			}

			return false;
		}

		return isValidPoshiScriptStatement(_returnPattern, poshiScript);
	}

	private static final String _ELEMENT_NAME = "return";

	private Pattern _returnPattern = Pattern.compile(
		"^return[\\s]*\"[\\s\\S]*\"[\\s]*;$");

}