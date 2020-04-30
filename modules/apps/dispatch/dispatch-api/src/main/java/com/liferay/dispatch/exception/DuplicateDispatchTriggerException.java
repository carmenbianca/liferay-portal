/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alessio Antonio Rendina
 */
public class DuplicateDispatchTriggerException extends PortalException {

	public DuplicateDispatchTriggerException() {
	}

	public DuplicateDispatchTriggerException(String msg) {
		super(msg);
	}

	public DuplicateDispatchTriggerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateDispatchTriggerException(Throwable cause) {
		super(cause);
	}

}