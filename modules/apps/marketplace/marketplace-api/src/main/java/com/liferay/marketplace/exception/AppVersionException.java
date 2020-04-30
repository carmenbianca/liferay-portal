/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Ryan Park
 */
public class AppVersionException extends PortalException {

	public AppVersionException() {
	}

	public AppVersionException(String msg) {
		super(msg);
	}

	public AppVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AppVersionException(Throwable cause) {
		super(cause);
	}

}