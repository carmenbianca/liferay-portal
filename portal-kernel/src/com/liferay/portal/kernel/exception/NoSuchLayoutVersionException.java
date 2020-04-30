/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLayoutVersionException extends NoSuchModelException {

	public NoSuchLayoutVersionException() {
	}

	public NoSuchLayoutVersionException(String msg) {
		super(msg);
	}

	public NoSuchLayoutVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLayoutVersionException(Throwable cause) {
		super(cause);
	}

}