/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json.data;

import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.FileUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author Igor Spasic
 */
public class FileData {

	public FileData(File file) {
		byte[] bytes = null;

		try {
			bytes = FileUtil.getBytes(file);
		}
		catch (IOException ioException) {
			bytes = null;
		}

		_content = Base64.encode(bytes);

		_name = file.getName();
		_size = file.length();
	}

	public String getContent() {
		return _content;
	}

	public String getName() {
		return _name;
	}

	public long getSize() {
		return _size;
	}

	public void setContent(String content) {
		_content = content;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setSize(long size) {
		_size = size;
	}

	private String _content;
	private String _name;
	private long _size;

}