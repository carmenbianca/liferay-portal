/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Sergio González
 */
public class LayoutFriendlyURLsException extends LocalizedException {

	public LayoutFriendlyURLsException() {
	}

	public LayoutFriendlyURLsException(String msg) {
		super(msg);
	}

	public LayoutFriendlyURLsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LayoutFriendlyURLsException(Throwable cause) {
		super(cause);
	}

}