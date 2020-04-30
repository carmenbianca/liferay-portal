/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateTableNameException extends PortalException {

	public DuplicateTableNameException() {
	}

	public DuplicateTableNameException(String msg) {
		super(msg);
	}

	public DuplicateTableNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateTableNameException(Throwable cause) {
		super(cause);
	}

}