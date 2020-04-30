/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.verify;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alexander Chow
 */
public class VerifyException extends PortalException {

	public VerifyException() {
	}

	public VerifyException(String msg) {
		super(msg);
	}

	public VerifyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public VerifyException(Throwable cause) {
		super(cause);
	}

}