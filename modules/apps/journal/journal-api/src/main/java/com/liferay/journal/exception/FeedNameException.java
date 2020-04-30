/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FeedNameException extends PortalException {

	public FeedNameException() {
	}

	public FeedNameException(String msg) {
		super(msg);
	}

	public FeedNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FeedNameException(Throwable cause) {
		super(cause);
	}

}