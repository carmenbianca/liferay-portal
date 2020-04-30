/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchBanException extends NoSuchModelException {

	public NoSuchBanException() {
	}

	public NoSuchBanException(String msg) {
		super(msg);
	}

	public NoSuchBanException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchBanException(Throwable cause) {
		super(cause);
	}

}