/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class MembershipRequestCommentsException extends PortalException {

	public MembershipRequestCommentsException() {
	}

	public MembershipRequestCommentsException(String msg) {
		super(msg);
	}

	public MembershipRequestCommentsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MembershipRequestCommentsException(Throwable cause) {
		super(cause);
	}

}