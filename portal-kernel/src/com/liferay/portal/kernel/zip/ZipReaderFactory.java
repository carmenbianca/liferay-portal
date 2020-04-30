/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Raymond Augé
 */
@ProviderType
public interface ZipReaderFactory {

	public ZipReader getZipReader(File file);

	public ZipReader getZipReader(InputStream inputStream) throws IOException;

}