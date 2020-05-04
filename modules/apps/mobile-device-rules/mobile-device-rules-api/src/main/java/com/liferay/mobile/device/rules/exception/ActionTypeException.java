/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Edward C. Han
 */
public class ActionTypeException extends PortalException {

	public ActionTypeException() {
	}

	public ActionTypeException(String msg) {
		super(msg);
	}

	public ActionTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ActionTypeException(Throwable cause) {
		super(cause);
	}

}