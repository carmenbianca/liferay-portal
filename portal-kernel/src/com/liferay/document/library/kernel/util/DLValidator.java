/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.util;

import com.liferay.document.library.kernel.exception.FileExtensionException;
import com.liferay.document.library.kernel.exception.FileNameException;
import com.liferay.document.library.kernel.exception.FileSizeException;
import com.liferay.document.library.kernel.exception.FolderNameException;
import com.liferay.document.library.kernel.exception.InvalidFileVersionException;
import com.liferay.document.library.kernel.exception.SourceFileNameException;

import java.io.File;
import java.io.InputStream;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Adolfo Pérez
 */
@ProviderType
public interface DLValidator {

	public String fixName(String name);

	public long getMaxAllowableSize();

	public boolean isValidName(String name);

	public void validateDirectoryName(String directoryName)
		throws FolderNameException;

	public void validateFileExtension(String fileName)
		throws FileExtensionException;

	public void validateFileName(String fileName) throws FileNameException;

	public void validateFileSize(String fileName, byte[] bytes)
		throws FileSizeException;

	public void validateFileSize(String fileName, File file)
		throws FileSizeException;

	public void validateFileSize(String fileName, InputStream is)
		throws FileSizeException;

	public void validateFileSize(String fileName, long size)
		throws FileSizeException;

	public void validateSourceFileExtension(
			String fileExtension, String sourceFileName)
		throws SourceFileNameException;

	public void validateVersionLabel(String versionLabel)
		throws InvalidFileVersionException;

}