/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchVirtualHostException extends NoSuchModelException {

	public NoSuchVirtualHostException() {
	}

	public NoSuchVirtualHostException(String msg) {
		super(msg);
	}

	public NoSuchVirtualHostException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchVirtualHostException(Throwable cause) {
		super(cause);
	}

}