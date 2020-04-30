/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFormInstanceReportException extends NoSuchModelException {

	public NoSuchFormInstanceReportException() {
	}

	public NoSuchFormInstanceReportException(String msg) {
		super(msg);
	}

	public NoSuchFormInstanceReportException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFormInstanceReportException(Throwable cause) {
		super(cause);
	}

}