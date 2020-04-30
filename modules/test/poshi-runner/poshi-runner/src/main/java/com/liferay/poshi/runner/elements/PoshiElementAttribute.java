/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.elements;

import com.liferay.poshi.runner.script.PoshiScriptParserException;
import com.liferay.poshi.runner.util.Validator;

import org.dom4j.Attribute;
import org.dom4j.tree.DefaultAttribute;

/**
 * @author Peter Yoo
 */
public class PoshiElementAttribute
	extends DefaultAttribute
	implements PoshiNode<Attribute, PoshiElementAttribute> {

	public PoshiElementAttribute(Attribute attribute) {
		super(
			attribute.getParent(), attribute.getName(), attribute.getValue(),
			attribute.getNamespace());
	}

	public PoshiElementAttribute(
		String name, String value, String poshiScript) {

		super(name, value);

		setPoshiScript(poshiScript);
	}

	@Override
	public PoshiElementAttribute clone(Attribute attribute) {
		return null;
	}

	@Override
	public PoshiElementAttribute clone(String poshiScript)
		throws PoshiScriptParserException {

		return null;
	}

	@Override
	public String getPoshiScript() {
		return _poshiScript;
	}

	@Override
	public void parsePoshiScript(String poshiScript)
		throws PoshiScriptParserException {
	}

	@Override
	public void setPoshiScript(String poshiScript) {
		_poshiScript = poshiScript;
	}

	public String toPoshiScript() {
		StringBuilder sb = new StringBuilder();

		sb.append(getName());
		sb.append(" = \"");

		String value = getValue();

		value = value.replaceAll("\"", "&quot;");

		sb.append(value);

		sb.append("\"");

		return sb.toString();
	}

	@Override
	public void validatePoshiScript() throws PoshiScriptParserException {
		if (Validator.isNull(getPoshiScript())) {
			return;
		}

		PoshiNode.super.validatePoshiScript();
	}

	private String _poshiScript;

}