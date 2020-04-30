/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alessio Antonio Rendina
 */
public class DispatchTriggerEndDateException extends PortalException {

	public DispatchTriggerEndDateException() {
	}

	public DispatchTriggerEndDateException(String msg) {
		super(msg);
	}

	public DispatchTriggerEndDateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DispatchTriggerEndDateException(Throwable cause) {
		super(cause);
	}

}