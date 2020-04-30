/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class TableNameException extends PortalException {

	public TableNameException() {
	}

	public TableNameException(String msg) {
		super(msg);
	}

	public TableNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TableNameException(Throwable cause) {
		super(cause);
	}

}