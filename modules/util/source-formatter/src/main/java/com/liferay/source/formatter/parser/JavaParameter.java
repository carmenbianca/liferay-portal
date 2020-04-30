/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.parser;

import java.util.Set;

/**
 * @author Hugo Huijser
 */
public class JavaParameter {

	public JavaParameter(
		String parameterName, String parameterType,
		Set<String> parameterAnnotations, boolean isFinal) {

		_parameterName = parameterName;
		_parameterType = parameterType;
		_parameterAnnotations = parameterAnnotations;
		_isFinal = isFinal;
	}

	public Set<String> getParameterAnnotations() {
		return _parameterAnnotations;
	}

	public String getParameterName() {
		return _parameterName;
	}

	public String getParameterType() {
		return _parameterType;
	}

	public boolean isFinal() {
		return _isFinal;
	}

	private final boolean _isFinal;
	private final Set<String> _parameterAnnotations;
	private final String _parameterName;
	private final String _parameterType;

}