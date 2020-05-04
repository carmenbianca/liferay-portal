/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.wab.extender.internal.adapter;

import com.liferay.portal.kernel.util.ServerDetector;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Raymond Augé
 */
public class ServletContextListenerExceptionAdapter
	implements ServletContextListener {

	public ServletContextListenerExceptionAdapter(
		ServletContextListener servletContextListener,
		ServletContext servletContext) {

		_servletContextListener = servletContextListener;
		_servletContext = servletContext;
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		if (ServerDetector.isJBoss() || ServerDetector.isWildfly()) {
			ServletContext servletContext =
				servletContextEvent.getServletContext();

			Thread thread = new Thread(
				"Context destroyed thread for ".concat(
					servletContext.getServletContextName())) {

				@Override
				public void run() {
					_destroyContext();
				}

			};

			thread.setDaemon(true);

			thread.start();

			try {
				thread.join();
			}
			catch (Exception exception) {
			}
		}
		else {
			_destroyContext();
		}
	}

	@Override
	public void contextInitialized(
		final ServletContextEvent servletContextEvent) {

		if (ServerDetector.isJBoss() || ServerDetector.isWildfly()) {
			ServletContext servletContext =
				servletContextEvent.getServletContext();

			Thread thread = new Thread(
				"Context initialized thread for ".concat(
					servletContext.getServletContextName())) {

				@Override
				public void run() {
					_initializeContext();
				}

			};

			thread.setDaemon(true);

			thread.start();

			try {
				thread.join();
			}
			catch (Exception exception) {
			}
		}
		else {
			_initializeContext();
		}
	}

	public Exception getException() {
		return _exception;
	}

	private void _destroyContext() {
		try {
			_servletContextListener.contextDestroyed(
				new ServletContextEvent(_servletContext));
		}
		catch (Exception exception) {
			_exception = exception;
		}
	}

	private void _initializeContext() {
		try {
			_servletContextListener.contextInitialized(
				new ServletContextEvent(_servletContext));
		}
		catch (Exception exception) {
			_exception = exception;
		}
	}

	private Exception _exception;
	private final ServletContext _servletContext;
	private final ServletContextListener _servletContextListener;

}