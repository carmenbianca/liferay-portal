/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.invitation.invite.members.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class MemberRequestAlreadyUsedException extends PortalException {

	public MemberRequestAlreadyUsedException() {
	}

	public MemberRequestAlreadyUsedException(String msg) {
		super(msg);
	}

	public MemberRequestAlreadyUsedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MemberRequestAlreadyUsedException(Throwable cause) {
		super(cause);
	}

}