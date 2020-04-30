/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.poller;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.poller.PollerHeader;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Edward Han
 */
public class PollerRequestHandlerUtil {

	public static PollerHeader getPollerHeader(String pollerRequestString) {
		return getPollerRequestHandler().getPollerHeader(pollerRequestString);
	}

	public static PollerRequestHandler getPollerRequestHandler() {
		return _pollerRequestHandler;
	}

	public static JSONObject processRequest(
			HttpServletRequest httpServletRequest, String pollerRequestString)
		throws Exception {

		return getPollerRequestHandler().processRequest(
			httpServletRequest, pollerRequestString);
	}

	public void setPollerRequestHandler(
		PollerRequestHandler pollerRequestHandler) {

		_pollerRequestHandler = pollerRequestHandler;
	}

	private static PollerRequestHandler _pollerRequestHandler;

}