/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

import com.liferay.petra.string.StringBundler;

import java.util.List;

/**
 * @author Hugo Huijser
 */
public class JavaTryStatement extends BaseJavaTerm {

	public void setResourceJavaVariableDefinitions(
		List<JavaVariableDefinition> resourceJavaVariableDefinitions) {

		_resourceJavaVariableDefinitions = resourceJavaVariableDefinitions;
	}

	@Override
	public String toString(
		String indent, String prefix, String suffix, int maxLineLength) {

		if (_resourceJavaVariableDefinitions == null) {
			return StringBundler.concat(indent, prefix, "try", suffix);
		}

		StringBundler sb = new StringBundler();

		sb.append(indent);

		indent = "\t" + indent;

		append(
			sb, _resourceJavaVariableDefinitions, "; ", indent,
			prefix + "try (", ")" + suffix, maxLineLength);

		return sb.toString();
	}

	private List<JavaVariableDefinition> _resourceJavaVariableDefinitions;

}