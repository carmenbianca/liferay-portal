/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionListener;

/**
 * <p>
 * See https://issues.liferay.com/browse/LEP-2299.
 * </p>
 *
 * @author Olaf Fricke
 * @author Brian Wing Shun Chan
 */
public class PortletSessionListenerLoader implements ServletContextListener {

	public PortletSessionListenerLoader(
		HttpSessionListener httpSessionListener) {

		_httpSessionListener = httpSessionListener;
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		PortletSessionListenerManager.removeHttpSessionListener(
			_httpSessionListener);

		_httpSessionListener = null;
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		PortletSessionListenerManager.addHttpSessionListener(
			_httpSessionListener);
	}

	private HttpSessionListener _httpSessionListener;

}