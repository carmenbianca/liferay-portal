/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Alessio Antonio Rendina
 */
public class NoSuchTriggerException extends NoSuchModelException {

	public NoSuchTriggerException() {
	}

	public NoSuchTriggerException(String msg) {
		super(msg);
	}

	public NoSuchTriggerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTriggerException(Throwable cause) {
		super(cause);
	}

}