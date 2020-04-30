/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.taglib.internal.servlet;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides utility methods to get servlet context information for Recycle Bin
 * tags.
 *
 * @author Michael Bradford
 */
@Component(immediate = true, service = {})
public class ServletContextUtil {

	public static final String getContextPath() {
		return _servletContext.getContextPath();
	}

	public static final ServletContext getServletContext() {
		return _servletContext;
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.trash.taglib)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static ServletContext _servletContext;

}