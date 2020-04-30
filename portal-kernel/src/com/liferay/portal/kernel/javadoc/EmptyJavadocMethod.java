/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.javadoc;

import java.lang.reflect.Method;

/**
 * @author Preston Crary
 */
public class EmptyJavadocMethod extends JavadocMethod {

	public EmptyJavadocMethod(String servletContextName, Method method) {
		super(servletContextName, null);

		_method = method;
	}

	@Override
	public Method getMethod() {
		return _method;
	}

	@Override
	public String getParameterComment(int index) {
		return null;
	}

	@Override
	public String getReturnComment() {
		return null;
	}

	@Override
	public String getThrowsComment(int index) {
		return null;
	}

	private final Method _method;

}