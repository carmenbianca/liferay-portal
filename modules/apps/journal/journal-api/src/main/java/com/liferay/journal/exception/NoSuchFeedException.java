/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFeedException extends NoSuchModelException {

	public NoSuchFeedException() {
	}

	public NoSuchFeedException(String msg) {
		super(msg);
	}

	public NoSuchFeedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFeedException(Throwable cause) {
		super(cause);
	}

}