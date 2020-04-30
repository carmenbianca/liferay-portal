/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class OAuth2ApplicationNameException extends PortalException {

	public OAuth2ApplicationNameException() {
	}

	public OAuth2ApplicationNameException(String msg) {
		super(msg);
	}

	public OAuth2ApplicationNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OAuth2ApplicationNameException(Throwable cause) {
		super(cause);
	}

}