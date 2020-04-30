/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alessio Antonio Rendina
 */
public class DispatchTriggerStartDateException extends PortalException {

	public DispatchTriggerStartDateException() {
	}

	public DispatchTriggerStartDateException(String msg) {
		super(msg);
	}

	public DispatchTriggerStartDateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DispatchTriggerStartDateException(Throwable cause) {
		super(cause);
	}

}