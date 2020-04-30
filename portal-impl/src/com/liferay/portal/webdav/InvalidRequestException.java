/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.webdav;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alexander Chow
 */
public class InvalidRequestException extends PortalException {

	public InvalidRequestException() {
	}

	public InvalidRequestException(String msg) {
		super(msg);
	}

	public InvalidRequestException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidRequestException(Throwable cause) {
		super(cause);
	}

}