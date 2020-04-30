/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.display.page.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchDisplayPageEntryException extends NoSuchModelException {

	public NoSuchDisplayPageEntryException() {
	}

	public NoSuchDisplayPageEntryException(String msg) {
		super(msg);
	}

	public NoSuchDisplayPageEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchDisplayPageEntryException(Throwable cause) {
		super(cause);
	}

}