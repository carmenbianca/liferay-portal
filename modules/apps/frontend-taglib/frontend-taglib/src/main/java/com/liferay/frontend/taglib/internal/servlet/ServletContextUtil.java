/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.internal.servlet;

import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationRegistry;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Roberto Díaz
 */
@Component(immediate = true, service = {})
public class ServletContextUtil {

	public static final ScreenNavigationRegistry getScreenNavigationRegistry() {
		return _screenNavigationRegistry;
	}

	public static final ServletContext getServletContext() {
		return _servletContext;
	}

	@Reference(unbind = "-")
	protected void setScreenNavigationRegistry(
		ScreenNavigationRegistry screenNavigationRegistry) {

		_screenNavigationRegistry = screenNavigationRegistry;
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.frontend.taglib)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static ScreenNavigationRegistry _screenNavigationRegistry;
	private static ServletContext _servletContext;

}