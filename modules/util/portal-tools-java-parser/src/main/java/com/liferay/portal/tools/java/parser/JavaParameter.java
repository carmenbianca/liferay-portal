/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class JavaParameter extends BaseJavaTerm {

	public JavaParameter(
		String name, List<JavaAnnotation> javaAnnotations,
		List<JavaSimpleValue> modifiers, JavaType javaType) {

		_name = new JavaSimpleValue(name);
		_javaAnnotations = javaAnnotations;
		_modifiers = modifiers;
		_javaType = javaType;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		StringBundler sb = new StringBundler();

		sb.append(indent);

		indent = "\t" + indent;

		sb.append(prefix);

		if (ListUtil.isNotEmpty(_javaAnnotations)) {
			int index = sb.index();

			if (appendSingleLine(
					sb, _javaAnnotations, " ", "", " ", maxLineLength) &&
				(ListUtil.isEmpty(_modifiers) ||
				 appendSingleLine(
					 sb, _modifiers, " ", "", " ", maxLineLength)) &&
				appendSingleLine(sb, _javaType, "", " ", maxLineLength) &&
				appendSingleLine(sb, _name, "", suffix, maxLineLength)) {

				return sb.toString();
			}

			sb.setIndex(index);

			indent = append(
				sb, _javaAnnotations, " ", indent, "", " ", maxLineLength);

			if (ListUtil.isNotEmpty(_modifiers)) {
				indent = append(
					sb, _modifiers, " ", indent, "", " ", maxLineLength);
			}

			appendNewLine(sb, _javaType, indent, "", " ", maxLineLength);

			append(sb, _name, indent, "", suffix, maxLineLength);

			return sb.toString();
		}

		if (ListUtil.isNotEmpty(_modifiers)) {
			indent = append(
				sb, _modifiers, " ", indent, "", " ", maxLineLength);
		}

		indent = append(sb, _javaType, indent, "", " ", maxLineLength, false);

		append(sb, _name, indent, "", suffix, maxLineLength);

		return sb.toString();
	}

	private final List<JavaAnnotation> _javaAnnotations;
	private final JavaType _javaType;
	private final List<JavaSimpleValue> _modifiers;
	private final JavaSimpleValue _name;

}