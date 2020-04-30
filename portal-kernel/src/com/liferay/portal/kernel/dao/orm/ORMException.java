/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

/**
 * @author Brian Wing Shun Chan
 */
public class ORMException extends RuntimeException {

	public ORMException() {
	}

	public ORMException(String msg) {
		super(msg);
	}

	public ORMException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ORMException(Throwable cause) {
		super(cause);
	}

}