/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.rest.builder.internal.freemarker.tool.java;

/**
 * @author Peter Shin
 */
public class JavaMethodParameter {

	public JavaMethodParameter(String parameterName, String parameterType) {
		_parameterName = parameterName;
		_parameterType = parameterType;
	}

	public String getParameterName() {
		return _parameterName;
	}

	public String getParameterType() {
		return _parameterType;
	}

	private final String _parameterName;
	private final String _parameterType;

}