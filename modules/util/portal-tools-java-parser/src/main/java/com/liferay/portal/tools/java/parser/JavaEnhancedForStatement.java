/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaEnhancedForStatement extends BaseJavaLoopStatement {

	public JavaEnhancedForStatement(
		JavaExpression collectionJavaExpression,
		JavaVariableDefinition javaVariableDefinition) {

		_collectionJavaExpression = collectionJavaExpression;
		_javaVariableDefinition = javaVariableDefinition;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		StringBundler sb = appendLabelName(indent);

		if (sb.index() > 0) {
			sb.append("\n");
		}

		sb.append(indent);

		indent = "\t" + indent;

		indent = append(
			sb, _javaVariableDefinition, indent, prefix + "for (", " : ",
			maxLineLength);

		append(
			sb, _collectionJavaExpression, indent, "", ")" + suffix,
			maxLineLength);

		return sb.toString();
	}

	private final JavaExpression _collectionJavaExpression;
	private final JavaVariableDefinition _javaVariableDefinition;

}