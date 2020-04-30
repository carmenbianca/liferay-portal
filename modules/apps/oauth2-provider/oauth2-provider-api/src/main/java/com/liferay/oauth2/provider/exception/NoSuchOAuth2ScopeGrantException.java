/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchOAuth2ScopeGrantException extends NoSuchModelException {

	public NoSuchOAuth2ScopeGrantException() {
	}

	public NoSuchOAuth2ScopeGrantException(String msg) {
		super(msg);
	}

	public NoSuchOAuth2ScopeGrantException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchOAuth2ScopeGrantException(Throwable cause) {
		super(cause);
	}

}