/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FeedContentFieldException extends PortalException {

	public FeedContentFieldException() {
	}

	public FeedContentFieldException(String msg) {
		super(msg);
	}

	public FeedContentFieldException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FeedContentFieldException(Throwable cause) {
		super(cause);
	}

}