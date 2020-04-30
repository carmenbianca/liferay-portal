/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.invitation.invite.members.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchMemberRequestException extends NoSuchModelException {

	public NoSuchMemberRequestException() {
	}

	public NoSuchMemberRequestException(String msg) {
		super(msg);
	}

	public NoSuchMemberRequestException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchMemberRequestException(Throwable cause) {
		super(cause);
	}

}