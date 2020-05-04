/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import java.util.Arrays;

/**
 * @author Shuyang Zhou
 */
public class MethodHandler implements Serializable {

	public MethodHandler(Method method, Object... arguments) {
		this(new MethodKey(method), arguments);
	}

	public MethodHandler(MethodKey methodKey, Object... arguments) {
		_methodKey = methodKey;
		_arguments = arguments;
	}

	public Object[] getArguments() {
		Object[] arguments = new Object[_arguments.length];

		System.arraycopy(_arguments, 0, arguments, 0, _arguments.length);

		return arguments;
	}

	public MethodKey getMethodKey() {
		return _methodKey;
	}

	public Object invoke() throws Exception {
		Method method = _methodKey.getMethod();

		Object targetObject = null;

		if (!Modifier.isStatic(method.getModifiers())) {
			Class<?> targetClass = _methodKey.getDeclaringClass();

			targetObject = targetClass.newInstance();
		}

		return method.invoke(targetObject, _arguments);
	}

	public Object invoke(Object target) throws Exception {
		Method method = _methodKey.getMethod();

		return method.invoke(target, _arguments);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{arguments=");
		sb.append(Arrays.toString(_arguments));
		sb.append(", methodKey=");
		sb.append(_methodKey);
		sb.append("}");

		return sb.toString();
	}

	private final Object[] _arguments;
	private final MethodKey _methodKey;

}