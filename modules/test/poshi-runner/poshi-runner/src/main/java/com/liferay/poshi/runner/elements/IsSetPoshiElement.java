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
public class IsSetPoshiElement extends PoshiElement {

	@Override
	public PoshiElement clone(Element element) {
		if (isElementType(_ELEMENT_NAME, element)) {
			return new IsSetPoshiElement(element);
		}

		return null;
	}

	@Override
	public PoshiElement clone(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		if (_isElementType(parentPoshiElement, poshiScript)) {
			return new IsSetPoshiElement(parentPoshiElement, poshiScript);
		}

		return null;
	}

	@Override
	public void parsePoshiScript(String poshiScript)
		throws PoshiScriptParserException {

		String issetContent = getParentheticalContent(poshiScript);

		addAttribute("var", issetContent);
	}

	@Override
	public String toPoshiScript() {
		return "isSet(" + attributeValue("var") + ")";
	}

	protected IsSetPoshiElement() {
	}

	protected IsSetPoshiElement(Element element) {
		super(_ELEMENT_NAME, element);
	}

	protected IsSetPoshiElement(List<Attribute> attributes, List<Node> nodes) {
		super(_ELEMENT_NAME, attributes, nodes);
	}

	protected IsSetPoshiElement(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		super(_ELEMENT_NAME, parentPoshiElement, poshiScript);
	}

	@Override
	protected String getBlockName() {
		return _POSHI_SCRIPT_KEYWORD;
	}

	@Override
	protected Pattern getConditionPattern() {
		return _conditionPattern;
	}

	private boolean _isElementType(
		PoshiElement parentPoshiElement, String poshiScript) {

		return isConditionElementType(parentPoshiElement, poshiScript);
	}

	private static final String _ELEMENT_NAME = "isset";

	private static final String _POSHI_SCRIPT_KEYWORD = "isSet";

	private static final Pattern _conditionPattern = Pattern.compile(
		"^" + _POSHI_SCRIPT_KEYWORD + "\\([\\w]*\\)$");

}