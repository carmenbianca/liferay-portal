/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Ryan Park
 */
public class AppPropertiesException extends PortalException {

	public AppPropertiesException() {
	}

	public AppPropertiesException(String msg) {
		super(msg);
	}

	public AppPropertiesException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AppPropertiesException(Throwable cause) {
		super(cause);
	}

}