/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchInstanceException extends NoSuchModelException {

	public NoSuchInstanceException() {
	}

	public NoSuchInstanceException(String msg) {
		super(msg);
	}

	public NoSuchInstanceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchInstanceException(Throwable cause) {
		super(cause);
	}

}