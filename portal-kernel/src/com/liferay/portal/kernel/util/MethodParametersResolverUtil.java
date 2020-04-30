/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.lang.reflect.Method;

/**
 * @author Igor Spasic
 */
public class MethodParametersResolverUtil {

	public static MethodParametersResolver getMethodParametersResolver() {
		return _methodParametersResolver;
	}

	public static MethodParameter[] resolveMethodParameters(Method method) {
		return getMethodParametersResolver().resolveMethodParameters(method);
	}

	public void setMethodParametersResolver(
		MethodParametersResolver methodParametersResolver) {

		_methodParametersResolver = methodParametersResolver;
	}

	private static MethodParametersResolver _methodParametersResolver;

}