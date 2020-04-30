/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.io.File;
import java.io.InputStream;

import java.util.Set;

/**
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 */
public interface MimeTypes {

	public String getContentType(File file);

	public String getContentType(File file, String fileName);

	public String getContentType(InputStream inputStream, String fileName);

	public String getContentType(String fileName);

	public String getExtensionContentType(String extension);

	public Set<String> getExtensions(String contentType);

	public boolean isWebImage(String mimeType);

}