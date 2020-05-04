/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.nio.intraband.proxy;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.nio.intraband.proxy.ExceptionHandler;

/**
 * @author Shuyang Zhou
 */
public class WarnLogExceptionHandler implements ExceptionHandler {

	public static final WarnLogExceptionHandler INSTANCE =
		new WarnLogExceptionHandler();

	@Override
	public void onException(Exception exception) {
		if (_log.isWarnEnabled()) {
			_log.warn(exception, exception);
		}
	}

	private WarnLogExceptionHandler() {
	}

	private static final Log _log = LogFactoryUtil.getLog(
		WarnLogExceptionHandler.class);

}