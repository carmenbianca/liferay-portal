/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class JavaCatchStatement extends BaseJavaTerm {

	public JavaCatchStatement(
		List<JavaSimpleValue> modifiers, String parameterName,
		List<JavaType> parameterJavaTypes) {

		_modifiers = modifiers;
		_parameterName = new JavaSimpleValue(parameterName);
		_parameterJavaTypes = parameterJavaTypes;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		StringBundler sb = new StringBundler();

		sb.append(indent);

		indent = "\t" + indent;

		prefix = prefix + "catch (";

		if (ListUtil.isNotEmpty(_modifiers)) {
			appendSingleLine(sb, _modifiers, " ", prefix, " ", maxLineLength);

			prefix = StringPool.BLANK;
		}

		indent = append(
			sb, _parameterJavaTypes, " | ", indent, prefix, " ", maxLineLength);

		append(sb, _parameterName, indent, "", ")" + suffix, maxLineLength);

		return sb.toString();
	}

	private final List<JavaSimpleValue> _modifiers;
	private final List<JavaType> _parameterJavaTypes;
	private final JavaSimpleValue _parameterName;

}