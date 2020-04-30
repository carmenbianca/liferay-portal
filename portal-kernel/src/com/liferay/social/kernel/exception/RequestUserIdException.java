/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class RequestUserIdException extends PortalException {

	public RequestUserIdException() {
	}

	public RequestUserIdException(String msg) {
		super(msg);
	}

	public RequestUserIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequestUserIdException(Throwable cause) {
		super(cause);
	}

}