/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Ryan Park
 */
public class AppTitleException extends PortalException {

	public AppTitleException() {
	}

	public AppTitleException(String msg) {
		super(msg);
	}

	public AppTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AppTitleException(Throwable cause) {
		super(cause);
	}

}