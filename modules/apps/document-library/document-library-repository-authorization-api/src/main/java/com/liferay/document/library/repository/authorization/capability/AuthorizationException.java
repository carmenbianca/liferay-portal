/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.authorization.capability;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Adolfo Pérez
 */
public class AuthorizationException extends PortalException {

	protected AuthorizationException() {
	}

	protected AuthorizationException(String msg) {
		super(msg);
	}

	protected AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	protected AuthorizationException(Throwable cause) {
		super(cause);
	}

}