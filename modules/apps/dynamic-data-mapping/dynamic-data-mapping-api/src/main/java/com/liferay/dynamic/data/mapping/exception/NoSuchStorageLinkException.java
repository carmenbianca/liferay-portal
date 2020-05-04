/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchStorageLinkException extends NoSuchModelException {

	public NoSuchStorageLinkException() {
	}

	public NoSuchStorageLinkException(String msg) {
		super(msg);
	}

	public NoSuchStorageLinkException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchStorageLinkException(Throwable cause) {
		super(cause);
	}

}