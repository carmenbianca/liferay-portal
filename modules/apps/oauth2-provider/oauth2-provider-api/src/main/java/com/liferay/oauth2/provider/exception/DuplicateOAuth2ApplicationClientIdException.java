/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateOAuth2ApplicationClientIdException
	extends PortalException {

	public DuplicateOAuth2ApplicationClientIdException() {
	}

	public DuplicateOAuth2ApplicationClientIdException(String msg) {
		super(msg);
	}

	public DuplicateOAuth2ApplicationClientIdException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public DuplicateOAuth2ApplicationClientIdException(Throwable cause) {
		super(cause);
	}

}