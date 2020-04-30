/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchModelException extends PortalException {

	public NoSuchModelException() {
	}

	public NoSuchModelException(String msg) {
		super(msg);
	}

	public NoSuchModelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchModelException(Throwable cause) {
		super(cause);
	}

}