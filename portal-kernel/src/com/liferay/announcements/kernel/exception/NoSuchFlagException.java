/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.announcements.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFlagException extends NoSuchModelException {

	public NoSuchFlagException() {
	}

	public NoSuchFlagException(String msg) {
		super(msg);
	}

	public NoSuchFlagException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFlagException(Throwable cause) {
		super(cause);
	}

}