/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hugo Huijser
 */
public class JavaEnumConstantDefinitions extends BaseJavaTerm {

	public void addJavaEnumConstantDefinition(
		JavaEnumConstantDefinition javaEnumConstantDefinition) {

		_javaEnumConstantDefinitionList.add(javaEnumConstantDefinition);
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		StringBundler sb = new StringBundler();

		sb.append(indent);

		indent = "\t" + indent;

		append(
			sb, _javaEnumConstantDefinitionList, indent, prefix, suffix,
			maxLineLength);

		return sb.toString();
	}

	private final List<JavaEnumConstantDefinition>
		_javaEnumConstantDefinitionList = new ArrayList<>();

}