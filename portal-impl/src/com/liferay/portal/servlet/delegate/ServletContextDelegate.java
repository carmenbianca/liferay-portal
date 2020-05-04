/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.delegate;

import com.liferay.portal.asm.ASMWrapperUtil;

import javax.servlet.ServletContext;

/**
 * @author Shuyang Zhou
 */
public class ServletContextDelegate {

	public static ServletContext create(ServletContext servletContext) {
		Class<?> clazz = servletContext.getClass();

		return ASMWrapperUtil.createASMWrapper(
			clazz.getClassLoader(), ServletContext.class,
			new ServletContextDelegate(servletContext), servletContext);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ServletContext)) {
			return false;
		}

		ServletContext servletContext = (ServletContext)obj;

		return servletContext.equals(_servletContext);
	}

	public String getContextPath() {
		return _contextPath;
	}

	public String getServletContextName() {
		return _servletContextName;
	}

	@Override
	public int hashCode() {
		return _servletContext.hashCode();
	}

	private ServletContextDelegate(ServletContext servletContext) {
		_servletContext = servletContext;

		_contextPath = servletContext.getContextPath();
		_servletContextName = servletContext.getServletContextName();
	}

	private final String _contextPath;
	private final ServletContext _servletContext;
	private final String _servletContextName;

}