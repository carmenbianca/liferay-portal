/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTagException extends NoSuchModelException {

	public NoSuchTagException() {
	}

	public NoSuchTagException(String msg) {
		super(msg);
	}

	public NoSuchTagException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTagException(Throwable cause) {
		super(cause);
	}

}