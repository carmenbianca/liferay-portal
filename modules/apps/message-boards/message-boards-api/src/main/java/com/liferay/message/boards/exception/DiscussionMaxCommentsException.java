/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DiscussionMaxCommentsException extends PortalException {

	public DiscussionMaxCommentsException() {
	}

	public DiscussionMaxCommentsException(String msg) {
		super(msg);
	}

	public DiscussionMaxCommentsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DiscussionMaxCommentsException(Throwable cause) {
		super(cause);
	}

}