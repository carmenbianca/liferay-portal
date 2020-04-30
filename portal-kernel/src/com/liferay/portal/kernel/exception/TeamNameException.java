/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class TeamNameException extends PortalException {

	public TeamNameException() {
	}

	public TeamNameException(String msg) {
		super(msg);
	}

	public TeamNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TeamNameException(Throwable cause) {
		super(cause);
	}

}