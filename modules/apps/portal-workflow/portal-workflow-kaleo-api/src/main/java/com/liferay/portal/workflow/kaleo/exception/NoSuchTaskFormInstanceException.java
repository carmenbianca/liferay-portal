/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTaskFormInstanceException extends NoSuchModelException {

	public NoSuchTaskFormInstanceException() {
	}

	public NoSuchTaskFormInstanceException(String msg) {
		super(msg);
	}

	public NoSuchTaskFormInstanceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTaskFormInstanceException(Throwable cause) {
		super(cause);
	}

}