/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

/**
 * @author Raymond Augé
 */
public class DirectRequestDispatcherFactoryUtil {

	public static DirectRequestDispatcherFactory
		getDirectRequestDispatcherFactory() {

		return _directRequestDispatcherFactory;
	}

	public static RequestDispatcher getRequestDispatcher(
		ServletContext servletContext, String path) {

		return getDirectRequestDispatcherFactory().getRequestDispatcher(
			servletContext, path);
	}

	public static RequestDispatcher getRequestDispatcher(
		ServletRequest servletRequest, String path) {

		return getDirectRequestDispatcherFactory().getRequestDispatcher(
			servletRequest, path);
	}

	public void setDirectRequestDispatcherFactory(
		DirectRequestDispatcherFactory directRequestDispatcherFactory) {

		_directRequestDispatcherFactory = directRequestDispatcherFactory;
	}

	private static DirectRequestDispatcherFactory
		_directRequestDispatcherFactory;

}