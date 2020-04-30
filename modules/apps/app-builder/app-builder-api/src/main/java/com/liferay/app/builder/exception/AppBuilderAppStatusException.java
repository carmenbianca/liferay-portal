/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class AppBuilderAppStatusException extends PortalException {

	public AppBuilderAppStatusException() {
	}

	public AppBuilderAppStatusException(String msg) {
		super(msg);
	}

	public AppBuilderAppStatusException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AppBuilderAppStatusException(Throwable cause) {
		super(cause);
	}

}