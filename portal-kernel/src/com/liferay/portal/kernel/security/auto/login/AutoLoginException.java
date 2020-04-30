/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.auto.login;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class AutoLoginException extends PortalException {

	public AutoLoginException() {
	}

	public AutoLoginException(String msg) {
		super(msg);
	}

	public AutoLoginException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AutoLoginException(Throwable cause) {
		super(cause);
	}

}