/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resource;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;

import java.io.InputStream;

/**
 * @author Shuyang Zhou
 */
public class StringResourceRetriever implements ResourceRetriever {

	public StringResourceRetriever(String resource) {
		_inputStream = new UnsyncByteArrayInputStream(resource.getBytes());
	}

	@Override
	public InputStream getInputStream() {
		return _inputStream;
	}

	private final InputStream _inputStream;

}