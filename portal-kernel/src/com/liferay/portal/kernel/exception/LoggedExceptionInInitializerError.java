/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class LoggedExceptionInInitializerError
	extends ExceptionInInitializerError {

	public LoggedExceptionInInitializerError(Throwable cause) {
		super(cause);

		_log.error(cause, cause);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LoggedExceptionInInitializerError.class);

}