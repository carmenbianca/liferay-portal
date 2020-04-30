/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateOAuth2ScopeGrantException extends PortalException {

	public DuplicateOAuth2ScopeGrantException() {
	}

	public DuplicateOAuth2ScopeGrantException(String msg) {
		super(msg);
	}

	public DuplicateOAuth2ScopeGrantException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateOAuth2ScopeGrantException(Throwable cause) {
		super(cause);
	}

}