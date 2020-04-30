/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.webserver;

/**
 * @author Brian Wing Shun Chan
 * @since  6.1, replaced com.liferay.portal.kernel.servlet.ImageServletTokenUtil
 */
public class WebServerServletTokenUtil {

	public static String getToken(long imageId) {
		return getWebServerServletToken().getToken(imageId);
	}

	public static WebServerServletToken getWebServerServletToken() {
		return _webServerServletToken;
	}

	public static void resetToken(long imageId) {
		getWebServerServletToken().resetToken(imageId);
	}

	public void setWebServerServletToken(
		WebServerServletToken webServerServletToken) {

		_webServerServletToken = webServerServletToken;
	}

	private static WebServerServletToken _webServerServletToken;

}