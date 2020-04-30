/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.elements;

import com.liferay.poshi.runner.script.PoshiScriptParserException;
import com.liferay.poshi.runner.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Element;

/**
 * @author Kenji Heigel
 */
public class ContainsPoshiElement extends PoshiElement {

	@Override
	public PoshiElement clone(Element element) {
		if (isElementType(_ELEMENT_NAME, element)) {
			return new ContainsPoshiElement(element);
		}

		return null;
	}

	@Override
	public PoshiElement clone(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		if (_isElementType(parentPoshiElement, poshiScript)) {
			return new ContainsPoshiElement(parentPoshiElement, poshiScript);
		}

		return null;
	}

	@Override
	public void parsePoshiScript(String poshiScript)
		throws PoshiScriptParserException {

		Matcher matcher = _conditionPattern.matcher(poshiScript);

		matcher.find();

		addAttribute("string", matcher.group(1));
		addAttribute("substring", matcher.group(2));
	}

	@Override
	public String toPoshiScript() {
		return StringUtil.combine(
			_ELEMENT_NAME, "(\"" + attributeValue("string") + "\", \"",
			attributeValue("substring"), "\")");
	}

	protected ContainsPoshiElement() {
	}

	protected ContainsPoshiElement(Element element) {
		super(_ELEMENT_NAME, element);
	}

	protected ContainsPoshiElement(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		super(_ELEMENT_NAME, parentPoshiElement, poshiScript);
	}

	@Override
	protected String getBlockName() {
		return _ELEMENT_NAME;
	}

	private boolean _isElementType(
		PoshiElement parentPoshiElement, String poshiScript) {

		if (!isConditionValidInParent(parentPoshiElement)) {
			return false;
		}

		Matcher matcher = _conditionPattern.matcher(poshiScript);

		return matcher.find();
	}

	private static final String _ELEMENT_NAME = "contains";

	private static final Pattern _conditionPattern = Pattern.compile(
		"^" + _ELEMENT_NAME + "\\(\"(.*)\"[\\s]*,[\\s]*\"(.*)\"\\)$");

}