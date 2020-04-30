/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Raymond Augé
 */
public class ZipReaderFactoryUtil {

	public static ZipReader getZipReader(File file) {
		return getZipReaderFactory().getZipReader(file);
	}

	public static ZipReader getZipReader(InputStream inputStream)
		throws IOException {

		return getZipReaderFactory().getZipReader(inputStream);
	}

	public static ZipReaderFactory getZipReaderFactory() {
		return _zipReaderFactory;
	}

	public void setZipReaderFactory(ZipReaderFactory zipReaderFactory) {
		_zipReaderFactory = zipReaderFactory;
	}

	private static ZipReaderFactory _zipReaderFactory;

}