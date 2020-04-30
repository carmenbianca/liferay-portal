/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchMailingListException extends NoSuchModelException {

	public NoSuchMailingListException() {
	}

	public NoSuchMailingListException(String msg) {
		super(msg);
	}

	public NoSuchMailingListException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchMailingListException(Throwable cause) {
		super(cause);
	}

}