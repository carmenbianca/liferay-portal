/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.powwow.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Shinn Lok
 */
public class NoSuchParticipantException extends NoSuchModelException {

	public NoSuchParticipantException() {
	}

	public NoSuchParticipantException(String msg) {
		super(msg);
	}

	public NoSuchParticipantException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchParticipantException(Throwable cause) {
		super(cause);
	}

}