/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ColumnTypeException extends PortalException {

	public ColumnTypeException() {
	}

	public ColumnTypeException(String msg) {
		super(msg);
	}

	public ColumnTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ColumnTypeException(Throwable cause) {
		super(cause);
	}

}