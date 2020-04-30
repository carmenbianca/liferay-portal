/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchDiscussionException extends NoSuchModelException {

	public NoSuchDiscussionException() {
	}

	public NoSuchDiscussionException(String msg) {
		super(msg);
	}

	public NoSuchDiscussionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchDiscussionException(Throwable cause) {
		super(cause);
	}

}