/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPhoneException extends NoSuchModelException {

	public NoSuchPhoneException() {
	}

	public NoSuchPhoneException(String msg) {
		super(msg);
	}

	public NoSuchPhoneException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPhoneException(Throwable cause) {
		super(cause);
	}

}