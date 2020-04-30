/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Alessio Antonio Rendina
 */
public class InitializationException extends PortalException {

	public InitializationException() {
	}

	public InitializationException(String msg) {
		super(msg);
	}

	public InitializationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InitializationException(Throwable cause) {
		super(cause);
	}

}