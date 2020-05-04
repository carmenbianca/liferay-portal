/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchOAuth2AuthorizationException extends NoSuchModelException {

	public NoSuchOAuth2AuthorizationException() {
	}

	public NoSuchOAuth2AuthorizationException(String msg) {
		super(msg);
	}

	public NoSuchOAuth2AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchOAuth2AuthorizationException(Throwable cause) {
		super(cause);
	}

}