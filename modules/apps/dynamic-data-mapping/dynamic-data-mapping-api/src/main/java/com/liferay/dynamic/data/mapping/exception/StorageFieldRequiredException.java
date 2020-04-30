/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class StorageFieldRequiredException extends StorageException {

	public StorageFieldRequiredException() {
	}

	public StorageFieldRequiredException(String msg) {
		super(msg);
	}

	public StorageFieldRequiredException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public StorageFieldRequiredException(Throwable cause) {
		super(cause);
	}

}