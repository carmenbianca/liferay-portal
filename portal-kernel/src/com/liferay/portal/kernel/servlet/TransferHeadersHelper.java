/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tina Tian
 */
public interface TransferHeadersHelper {

	public RequestDispatcher getTransferHeadersRequestDispatcher(
		RequestDispatcher requestDispatcher);

	public void transferHeaders(
		Map<String, Object[]> headers, HttpServletResponse httpServletResponse);

}