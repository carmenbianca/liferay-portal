/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.context.helper.internal.definition;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Miguel Pastor
 */
public class MockServlet extends GenericServlet {

	@Override
	public void service(
		ServletRequest servletRequest, ServletResponse servletResponse) {
	}

}