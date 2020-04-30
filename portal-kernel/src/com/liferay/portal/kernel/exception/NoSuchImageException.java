/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchImageException extends NoSuchModelException {

	public NoSuchImageException() {
	}

	public NoSuchImageException(String msg) {
		super(msg);
	}

	public NoSuchImageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchImageException(Throwable cause) {
		super(cause);
	}

}