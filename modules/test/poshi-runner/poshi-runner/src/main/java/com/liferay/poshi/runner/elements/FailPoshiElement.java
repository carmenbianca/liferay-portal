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
public class FailPoshiElement extends EchoPoshiElement {

	@Override
	public PoshiElement clone(Element element) {
		if (isElementType(_ELEMENT_NAME, element)) {
			return new FailPoshiElement(element);
		}

		return null;
	}

	@Override
	public PoshiElement clone(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		if (_isElementType(poshiScript)) {
			return new FailPoshiElement(parentPoshiElement, poshiScript);
		}

		return null;
	}

	protected FailPoshiElement() {
	}

	protected FailPoshiElement(Element element) {
		super(_ELEMENT_NAME, element);
	}

	protected FailPoshiElement(List<Attribute> attributes, List<Node> nodes) {
		super(_ELEMENT_NAME, attributes, nodes);
	}

	protected FailPoshiElement(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		super(_ELEMENT_NAME, parentPoshiElement, poshiScript);
	}

	@Override
	protected String getBlockName() {
		return "fail";
	}

	private boolean _isElementType(String poshiScript) {
		return isValidPoshiScriptStatement(_statementPattern, poshiScript);
	}

	private static final String _ELEMENT_NAME = "fail";

	private static final String _POSHI_SCRIPT_KEYWORD = _ELEMENT_NAME;

	private static final Pattern _statementPattern = Pattern.compile(
		"^" + _POSHI_SCRIPT_KEYWORD + PARAMETER_REGEX + STATEMENT_END_REGEX);

}