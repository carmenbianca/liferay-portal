/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.elements;

import com.liferay.poshi.runner.script.PoshiScriptParserException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.Node;

/**
 * @author Kenji Heigel
 */
public class CommandPoshiElement extends PoshiElement {

	@Override
	public PoshiElement clone(Element element) {
		if (isElementType(_ELEMENT_NAME, element)) {
			return new CommandPoshiElement(element);
		}

		return null;
	}

	@Override
	public PoshiElement clone(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		if (_isElementType(parentPoshiElement, poshiScript)) {
			return new CommandPoshiElement(parentPoshiElement, poshiScript);
		}

		return null;
	}

	@Override
	public String getPoshiLogDescriptor() {
		return getBlockName();
	}

	@Override
	public int getPoshiScriptLineNumber() {
		return getPoshiScriptLineNumber(false);
	}

	@Override
	public void parsePoshiScript(String poshiScript)
		throws PoshiScriptParserException {

		String blockName = getBlockName(poshiScript);

		Matcher poshiScriptAnnotationMatcher =
			poshiScriptAnnotationPattern.matcher(blockName);

		while (poshiScriptAnnotationMatcher.find()) {
			String annotation = poshiScriptAnnotationMatcher.group();

			if (annotation.startsWith("@description")) {
				add(PoshiNodeFactory.newPoshiNode(this, annotation));

				continue;
			}

			String name = getNameFromAssignment(annotation);
			String value = getDoubleQuotedContent(annotation);

			addAttribute(name, value);
		}

		Matcher blockNameMatcher = _blockNamePattern.matcher(blockName);

		if (blockNameMatcher.find()) {
			addAttribute("name", blockNameMatcher.group(3));
		}

		String blockContent = getBlockContent(poshiScript);

		for (String poshiScriptSnippet : getPoshiScriptSnippets(blockContent)) {
			add(PoshiNodeFactory.newPoshiNode(this, poshiScriptSnippet));
		}
	}

	@Override
	public String toPoshiScript() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n");

		DescriptionPoshiElement descriptionPoshiElement =
			(DescriptionPoshiElement)element("description");

		if (descriptionPoshiElement != null) {
			sb.append("\n\t");

			sb.append(descriptionPoshiElement.toPoshiScript());
		}

		for (PoshiElementAttribute poshiElementAttribute :
				toPoshiElementAttributes(attributeList())) {

			String name = poshiElementAttribute.getName();

			if (name.equals("name")) {
				continue;
			}

			sb.append("\n\t@");
			sb.append(poshiElementAttribute.toPoshiScript());
		}

		sb.append(createPoshiScriptBlock(getPoshiNodes()));

		return sb.toString();
	}

	protected CommandPoshiElement() {
	}

	protected CommandPoshiElement(Element element) {
		this(_ELEMENT_NAME, element);
	}

	protected CommandPoshiElement(
		List<Attribute> attributes, List<Node> nodes) {

		this(_ELEMENT_NAME, attributes, nodes);
	}

	protected CommandPoshiElement(
			PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		this(_ELEMENT_NAME, parentPoshiElement, poshiScript);
	}

	protected CommandPoshiElement(String name, Element element) {
		super(name, element);
	}

	protected CommandPoshiElement(
		String elementName, List<Attribute> attributes, List<Node> nodes) {

		super(elementName, attributes, nodes);
	}

	protected CommandPoshiElement(
			String name, PoshiElement parentPoshiElement, String poshiScript)
		throws PoshiScriptParserException {

		super(name, parentPoshiElement, poshiScript);
	}

	@Override
	protected String getBlockName() {
		return getPoshiScriptKeyword() + " " + attributeValue("name");
	}

	private boolean _isElementType(
		PoshiElement parentPoshiElement, String poshiScript) {

		if (!(parentPoshiElement instanceof DefinitionPoshiElement)) {
			return false;
		}

		return isValidPoshiScriptBlock(_blockNamePattern, poshiScript);
	}

	private static final String _ELEMENT_NAME = "command";

	private static final String _POSHI_SCRIPT_KEYWORD_REGEX =
		"(function|macro|test)[\\s]+";

	private static final Pattern _blockNamePattern = Pattern.compile(
		"^" + BLOCK_NAME_ANNOTATION_REGEX + _POSHI_SCRIPT_KEYWORD_REGEX +
			"[\\s]*([\\w]*)",
		Pattern.DOTALL);

}