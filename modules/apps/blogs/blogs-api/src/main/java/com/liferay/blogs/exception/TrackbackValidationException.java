/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class TrackbackValidationException extends PortalException {

	public TrackbackValidationException() {
	}

	public TrackbackValidationException(String msg) {
		super(msg);
	}

	public TrackbackValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TrackbackValidationException(Throwable cause) {
		super(cause);
	}

}