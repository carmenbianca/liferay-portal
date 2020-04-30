/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLayoutFriendlyURLException extends NoSuchModelException {

	public NoSuchLayoutFriendlyURLException() {
	}

	public NoSuchLayoutFriendlyURLException(String msg) {
		super(msg);
	}

	public NoSuchLayoutFriendlyURLException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLayoutFriendlyURLException(Throwable cause) {
		super(cause);
	}

}