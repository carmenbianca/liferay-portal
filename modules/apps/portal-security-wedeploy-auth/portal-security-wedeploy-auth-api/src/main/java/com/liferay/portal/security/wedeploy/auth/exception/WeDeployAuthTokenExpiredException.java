/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.wedeploy.auth.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Supritha Sundaram
 */
public class WeDeployAuthTokenExpiredException extends PortalException {

	public WeDeployAuthTokenExpiredException() {
	}

	public WeDeployAuthTokenExpiredException(String msg) {
		super(msg);
	}

	public WeDeployAuthTokenExpiredException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WeDeployAuthTokenExpiredException(Throwable cause) {
		super(cause);
	}

}