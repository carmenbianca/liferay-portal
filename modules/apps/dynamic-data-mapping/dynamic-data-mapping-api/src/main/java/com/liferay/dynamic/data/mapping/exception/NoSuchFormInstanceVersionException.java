/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFormInstanceVersionException extends NoSuchModelException {

	public NoSuchFormInstanceVersionException() {
	}

	public NoSuchFormInstanceVersionException(String msg) {
		super(msg);
	}

	public NoSuchFormInstanceVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFormInstanceVersionException(Throwable cause) {
		super(cause);
	}

}