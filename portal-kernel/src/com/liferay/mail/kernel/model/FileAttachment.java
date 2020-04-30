/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.kernel.model;

import java.io.File;

/**
 * @author Barrie Selack
 * @author Brian Wing Shun Chan
 */
public class FileAttachment {

	public FileAttachment() {
	}

	public FileAttachment(File file, String fileName) {
		_file = file;
		_fileName = fileName;
	}

	public File getFile() {
		return _file;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFile(File file) {
		_file = file;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	private File _file;
	private String _fileName;

}