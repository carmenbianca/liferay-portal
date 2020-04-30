/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPageResourceException extends NoSuchModelException {

	public NoSuchPageResourceException() {
	}

	public NoSuchPageResourceException(String msg) {
		super(msg);
	}

	public NoSuchPageResourceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPageResourceException(Throwable cause) {
		super(cause);
	}

}