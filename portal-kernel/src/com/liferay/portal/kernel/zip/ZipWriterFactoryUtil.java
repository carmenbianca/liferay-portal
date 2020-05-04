/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.zip;

import java.io.File;

/**
 * @author Raymond Augé
 */
public class ZipWriterFactoryUtil {

	public static ZipWriter getZipWriter() {
		return getZipWriterFactory().getZipWriter();
	}

	public static ZipWriter getZipWriter(File file) {
		return getZipWriterFactory().getZipWriter(file);
	}

	public static ZipWriterFactory getZipWriterFactory() {
		return _zipWriterFactory;
	}

	public void setZipWriterFactory(ZipWriterFactory zipWriterFactory) {
		_zipWriterFactory = zipWriterFactory;
	}

	private static ZipWriterFactory _zipWriterFactory;

}