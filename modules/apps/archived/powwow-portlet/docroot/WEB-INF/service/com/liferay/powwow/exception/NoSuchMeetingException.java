/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.powwow.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Shinn Lok
 */
public class NoSuchMeetingException extends NoSuchModelException {

	public NoSuchMeetingException() {
	}

	public NoSuchMeetingException(String msg) {
		super(msg);
	}

	public NoSuchMeetingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchMeetingException(Throwable cause) {
		super(cause);
	}

}