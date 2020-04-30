/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.remote.cors.client.test;

import com.liferay.petra.process.ProcessCallable;
import com.liferay.petra.process.ProcessException;
import com.liferay.portal.kernel.util.StringUtil;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;
import java.util.Map;

/**
 * @author Preston Crary
 */
public class AllowRestrictedHeadersCallable
	implements ProcessCallable<String[]> {

	public AllowRestrictedHeadersCallable(String url, String origin) {
		_url = url;
		_origin = origin;
	}

	@Override
	public String[] call() throws ProcessException {
		try {
			URL url = new URL(_url);

			HttpURLConnection httpURLConnection =
				(HttpURLConnection)url.openConnection();

			httpURLConnection.setRequestProperty("Origin", _origin);
			httpURLConnection.setRequestProperty(
				_ACCESS_CONTROL_REQUEST_METHOD, "GET");

			Map<String, List<String>> headerFields =
				httpURLConnection.getHeaderFields();

			return new String[] {
				StringUtil.merge(
					headerFields.get(_ACCESS_CONTROL_ALLOW_ORIGIN)),
				StringUtil.read(httpURLConnection.getInputStream()),
				String.valueOf(httpURLConnection.getResponseCode())
			};
		}
		catch (Exception exception) {
			throw new ProcessException(exception);
		}
	}

	private static final String _ACCESS_CONTROL_ALLOW_ORIGIN =
		"Access-Control-Allow-Origin";

	private static final String _ACCESS_CONTROL_REQUEST_METHOD =
		"Access-Control-Request-Method";

	private static final long serialVersionUID = 1L;

	private final String _origin;
	private final String _url;

}