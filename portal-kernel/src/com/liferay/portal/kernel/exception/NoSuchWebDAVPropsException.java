/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchWebDAVPropsException extends NoSuchModelException {

	public NoSuchWebDAVPropsException() {
	}

	public NoSuchWebDAVPropsException(String msg) {
		super(msg);
	}

	public NoSuchWebDAVPropsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchWebDAVPropsException(Throwable cause) {
		super(cause);
	}

}