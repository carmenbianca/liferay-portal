/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.parser;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Hugo Huijser
 */
public class JavaSignature {

	public void addParameter(
		String parameterName, String parameterType,
		Set<String> parameterAnnotations, boolean isFinal) {

		_parameters.add(
			new JavaParameter(
				parameterName, parameterType, parameterAnnotations, isFinal));
	}

	public List<JavaParameter> getParameters() {
		return _parameters;
	}

	public String getReturnType() {
		return _returnType;
	}

	public void setReturnType(String returnType) {
		_returnType = returnType;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(_parameters.size() * 2 + 1);

		sb.append(CharPool.OPEN_PARENTHESIS);

		for (JavaParameter parameter : _parameters) {
			sb.append(parameter.getParameterType());
			sb.append(CharPool.COMMA);
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append(CharPool.CLOSE_PARENTHESIS);

		return sb.toString();
	}

	private final List<JavaParameter> _parameters = new ArrayList<>();
	private String _returnType;

}