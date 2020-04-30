/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alessio Antonio Rendina
 */
public class DispatchTriggerNameException extends PortalException {

	public DispatchTriggerNameException() {
	}

	public DispatchTriggerNameException(String msg) {
		super(msg);
	}

	public DispatchTriggerNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DispatchTriggerNameException(Throwable cause) {
		super(cause);
	}

}