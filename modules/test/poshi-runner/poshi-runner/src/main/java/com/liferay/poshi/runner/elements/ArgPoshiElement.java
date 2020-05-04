/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.elements;

import com.liferay.poshi.runner.script.PoshiScriptParserException;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.Node;

/**
 * @author Kenji Heigel
 */
public class ArgPoshiElement extends PoshiElement {

	@Override
	public PoshiElement clone(Element element) {
		if (isElementType(_ELEMENT_NAME, element)) {
			return new ArgPoshiElement(element);
		}

		return null;
	}

	@Override
	public PoshiElement clone(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		if (_isElementType(parentPoshiElement, poshiScript)) {
			return new ArgPoshiElement(parentPoshiElement, poshiScript);
		}

		return null;
	}

	@Override
	public void parsePoshiScript(String poshiScript)
		throws PoshiScriptParserException {

		addAttribute("value", getDoubleQuotedContent(poshiScript));
	}

	@Override
	public String toPoshiScript() {
		return doubleQuoteContent(attributeValue("value"));
	}

	protected ArgPoshiElement() {
	}

	protected ArgPoshiElement(Element element) {
		super(_ELEMENT_NAME, element);
	}

	protected ArgPoshiElement(List<Attribute> attributes, List<Node> nodes) {
		super(_ELEMENT_NAME, attributes, nodes);
	}

	protected ArgPoshiElement(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		super(_ELEMENT_NAME, parentPoshiElement, poshiScript);
	}

	@Override
	protected String getBlockName() {
		return null;
	}

	private boolean _isElementType(
		PoshiElement parentPoshiElement, String poshiScript) {

		if (!(parentPoshiElement instanceof ExecutePoshiElement)) {
			return false;
		}

		poshiScript = poshiScript.trim();

		if (!poshiScript.startsWith("\"")) {
			return false;
		}

		return true;
	}

	private static final String _ELEMENT_NAME = "arg";

}