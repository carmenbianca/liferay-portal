/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FeedTargetPortletIdException extends PortalException {

	public FeedTargetPortletIdException() {
	}

	public FeedTargetPortletIdException(String msg) {
		super(msg);
	}

	public FeedTargetPortletIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FeedTargetPortletIdException(Throwable cause) {
		super(cause);
	}

}