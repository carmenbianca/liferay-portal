/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPageException extends NoSuchModelException {

	public NoSuchPageException() {
	}

	public NoSuchPageException(String msg) {
		super(msg);
	}

	public NoSuchPageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPageException(Throwable cause) {
		super(cause);
	}

}