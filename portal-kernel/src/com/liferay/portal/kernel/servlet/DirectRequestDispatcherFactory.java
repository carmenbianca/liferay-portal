/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

/**
 * @author Raymond Augé
 */
public interface DirectRequestDispatcherFactory {

	public RequestDispatcher getRequestDispatcher(
		ServletContext servletContext, String path);

	public RequestDispatcher getRequestDispatcher(
		ServletRequest servletRequest, String path);

}