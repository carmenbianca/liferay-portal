/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchMembershipRequestException extends NoSuchModelException {

	public NoSuchMembershipRequestException() {
	}

	public NoSuchMembershipRequestException(String msg) {
		super(msg);
	}

	public NoSuchMembershipRequestException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchMembershipRequestException(Throwable cause) {
		super(cause);
	}

}