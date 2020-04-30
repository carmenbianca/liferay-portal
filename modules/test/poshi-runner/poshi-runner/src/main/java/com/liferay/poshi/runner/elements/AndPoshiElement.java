/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
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
public class AndPoshiElement extends PoshiElement {

	@Override
	public PoshiElement clone(Element element) {
		if (isElementType(_ELEMENT_NAME, element)) {
			return new AndPoshiElement(element);
		}

		return null;
	}

	@Override
	public PoshiElement clone(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		if (_isElementType(parentPoshiElement, poshiScript)) {
			return new AndPoshiElement(parentPoshiElement, poshiScript);
		}

		return null;
	}

	@Override
	public void parsePoshiScript(String poshiScript)
		throws PoshiScriptParserException {

		for (String nestedCondition : getNestedConditions(poshiScript, "&&")) {
			nestedCondition = nestedCondition.trim();

			if (nestedCondition.endsWith(")") &&
				nestedCondition.startsWith("(")) {

				nestedCondition = getParentheticalContent(nestedCondition);
			}

			add(PoshiNodeFactory.newPoshiNode(this, nestedCondition));
		}
	}

	@Override
	public String toPoshiScript() {
		StringBuilder sb = new StringBuilder();

		for (PoshiElement poshiElement : toPoshiElements(elements())) {
			sb.append("(");
			sb.append(poshiElement.toPoshiScript());
			sb.append(") && ");
		}

		sb.setLength(sb.length() - 4);

		return sb.toString();
	}

	protected AndPoshiElement() {
	}

	protected AndPoshiElement(Element element) {
		super(_ELEMENT_NAME, element);
	}

	protected AndPoshiElement(List<Attribute> attributes, List<Node> nodes) {
		super(_ELEMENT_NAME, attributes, nodes);
	}

	protected AndPoshiElement(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		super(_ELEMENT_NAME, parentPoshiElement, poshiScript);
	}

	@Override
	protected String getBlockName() {
		return "and";
	}

	@Override
	protected Pattern getConditionPattern() {
		return _conditionPattern;
	}

	private boolean _isElementType(
		PoshiElement parentPoshiElement, String poshiScript) {

		if (!isConditionElementType(parentPoshiElement, poshiScript)) {
			return false;
		}

		List<String> nestedConditions = getNestedConditions(poshiScript, "&&");

		return !nestedConditions.isEmpty();
	}

	private static final String _ELEMENT_NAME = "and";

	private static final Pattern _conditionPattern = Pattern.compile(
		"^(?!!|else)[\\s\\S]*&&[\\s\\S]*$", Pattern.DOTALL);

}