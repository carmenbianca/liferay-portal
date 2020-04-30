/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;

/**
 * @author Shuyang Zhou
 */
public class URLUtil {

	public static long getLastModifiedTime(URL url) throws IOException {
		URLConnection urlConnection = null;

		try {
			urlConnection = url.openConnection();

			return urlConnection.getLastModified();
		}
		finally {
			if (urlConnection != null) {
				try {
					InputStream inputStream = urlConnection.getInputStream();

					inputStream.close();
				}
				catch (IOException ioException) {
				}
			}
		}
	}

}