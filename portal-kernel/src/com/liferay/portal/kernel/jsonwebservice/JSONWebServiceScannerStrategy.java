/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.jsonwebservice;

import java.lang.reflect.Method;

/**
 * @author Miguel Pastor
 */
public interface JSONWebServiceScannerStrategy {

	public MethodDescriptor[] scan(Object service);

	public class MethodDescriptor {

		public MethodDescriptor(Method method) {
			_method = method;

			_clazz = method.getDeclaringClass();
		}

		public Class<?> getDeclaringClass() {
			return _clazz;
		}

		public Method getMethod() {
			return _method;
		}

		private final Class<?> _clazz;
		private final Method _method;

	}

}