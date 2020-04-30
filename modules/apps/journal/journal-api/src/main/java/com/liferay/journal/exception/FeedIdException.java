/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FeedIdException extends PortalException {

	public FeedIdException() {
	}

	public FeedIdException(String msg) {
		super(msg);
	}

	public FeedIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FeedIdException(Throwable cause) {
		super(cause);
	}

}