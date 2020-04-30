/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resource;

import java.io.InputStream;

/**
 * @author Miguel Pastor
 */
public class ClassLoaderResourceRetriever implements ResourceRetriever {

	public ClassLoaderResourceRetriever(
		ClassLoader classLoader, String fileName) {

		_inputStream = classLoader.getResourceAsStream(fileName);
	}

	@Override
	public InputStream getInputStream() {
		return _inputStream;
	}

	private final InputStream _inputStream;

}