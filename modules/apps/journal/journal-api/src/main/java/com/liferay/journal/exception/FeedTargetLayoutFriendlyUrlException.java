/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FeedTargetLayoutFriendlyUrlException extends PortalException {

	public FeedTargetLayoutFriendlyUrlException() {
	}

	public FeedTargetLayoutFriendlyUrlException(String msg) {
		super(msg);
	}

	public FeedTargetLayoutFriendlyUrlException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FeedTargetLayoutFriendlyUrlException(Throwable cause) {
		super(cause);
	}

}