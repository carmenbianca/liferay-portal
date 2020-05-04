/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

/**
 * @author Hugo Huijser
 */
public class JavaLambdaParameter extends BaseJavaTerm {

	public JavaLambdaParameter(String name) {
		_name = new JavaSimpleValue(name);
	}

	public boolean hasJavaType() {
		if (_javaType == null) {
			return false;
		}

		return true;
	}

	public void setJavaType(JavaType javaType) {
		_javaType = javaType;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		if (_javaType == null) {
			return _name.toString(indent, prefix, suffix, maxLineLength);
		}

		StringBundler sb = new StringBundler();

		sb.append(indent);

		indent = "\t" + indent;

		indent = append(sb, _javaType, indent, prefix, " ", maxLineLength);

		append(sb, _name, indent, "", suffix, maxLineLength);

		return sb.toString();
	}

	private JavaType _javaType;
	private final JavaSimpleValue _name;

}