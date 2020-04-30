/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.audit.storage.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEventException extends NoSuchModelException {

	public NoSuchEventException() {
	}

	public NoSuchEventException(String msg) {
		super(msg);
	}

	public NoSuchEventException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEventException(Throwable cause) {
		super(cause);
	}

}