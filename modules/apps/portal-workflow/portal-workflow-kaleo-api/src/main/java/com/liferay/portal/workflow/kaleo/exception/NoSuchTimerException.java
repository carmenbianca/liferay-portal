/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTimerException extends NoSuchModelException {

	public NoSuchTimerException() {
	}

	public NoSuchTimerException(String msg) {
		super(msg);
	}

	public NoSuchTimerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTimerException(Throwable cause) {
		super(cause);
	}

}