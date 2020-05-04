/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class OAuth2ApplicationHomePageURLException extends PortalException {

	public OAuth2ApplicationHomePageURLException() {
	}

	public OAuth2ApplicationHomePageURLException(String msg) {
		super(msg);
	}

	public OAuth2ApplicationHomePageURLException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OAuth2ApplicationHomePageURLException(Throwable cause) {
		super(cause);
	}

}