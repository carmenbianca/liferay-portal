/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upload;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author Brian Myunghun Kim
 * @author Brian Wing Shun Chan
 */
public class LiferayServletRequest extends HttpServletRequestWrapper {

	public LiferayServletRequest(HttpServletRequest httpServletRequest) {
		super(httpServletRequest);

		_httpServletRequest = httpServletRequest;
	}

	public void cleanUp() {
		if (_lis != null) {
			_lis.cleanUp();
		}
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		if (_lis == null) {
			_lis = new LiferayInputStream(_httpServletRequest);
		}

		if (_finishedReadingOriginalStream) {

			// Return the cached input stream the second time the user requests
			// the input stream, otherwise, it will return an empty input stream
			// because it has already been parsed

			if (_cachedInputStream == null) {
				_cachedInputStream = _lis.getCachedInputStream();
			}

			return _cachedInputStream;
		}

		return _lis;
	}

	public void setFinishedReadingOriginalStream(
		boolean finishedReadingOriginalStream) {

		_finishedReadingOriginalStream = finishedReadingOriginalStream;
	}

	private ServletInputStream _cachedInputStream;
	private boolean _finishedReadingOriginalStream;
	private final HttpServletRequest _httpServletRequest;
	private LiferayInputStream _lis;

}