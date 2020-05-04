/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.Collection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Raymond Augé
 * @author Neil Griffin
 */
@ProviderType
public interface FileItem {

	public void delete();

	public String getContentType();

	public String getEncodedString();

	public String getFieldName();

	public String getFileName();

	public String getFileNameExtension();

	public String getFullFileName();

	public String getHeader(String name);

	public Collection<String> getHeaderNames();

	public Collection<String> getHeaders(String name);

	public InputStream getInputStream() throws IOException;

	public long getSize();

	public int getSizeThreshold();

	public File getStoreLocation();

	public String getString();

	public boolean isFormField();

	public boolean isInMemory();

	public void setString(String encode);

	public void write(File file) throws Exception;

}