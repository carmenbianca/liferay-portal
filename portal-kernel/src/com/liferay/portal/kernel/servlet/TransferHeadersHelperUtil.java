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
public class TransferHeadersHelperUtil {

	public static RequestDispatcher getTransferHeadersRequestDispatcher(
		RequestDispatcher requestDispatcher) {

		return _getTransferHeadersHelper().getTransferHeadersRequestDispatcher(
			requestDispatcher);
	}

	public static void transferHeaders(
		Map<String, Object[]> headers,
		HttpServletResponse httpServletResponse) {

		_getTransferHeadersHelper().transferHeaders(
			headers, httpServletResponse);
	}

	public void setTransferHeadersHelper(
		TransferHeadersHelper transferHeadersHelper) {

		_transferHeadersHelper = transferHeadersHelper;
	}

	private static TransferHeadersHelper _getTransferHeadersHelper() {
		return _transferHeadersHelper;
	}

	private static TransferHeadersHelper _transferHeadersHelper;

}