/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.convert.documentlibrary;

import com.liferay.portal.convert.ConvertException;

/**
 * @author László Csontos
 */
public class FileSystemStoreRootDirException extends ConvertException {

	public FileSystemStoreRootDirException() {
	}

	public FileSystemStoreRootDirException(String msg) {
		super(msg);
	}

	public FileSystemStoreRootDirException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FileSystemStoreRootDirException(Throwable cause) {
		super(cause);
	}

}