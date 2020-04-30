/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class OAuth2ApplicationRedirectURISchemeException
	extends PortalException {

	public OAuth2ApplicationRedirectURISchemeException() {
	}

	public OAuth2ApplicationRedirectURISchemeException(String msg) {
		super(msg);
	}

	public OAuth2ApplicationRedirectURISchemeException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public OAuth2ApplicationRedirectURISchemeException(Throwable cause) {
		super(cause);
	}

}