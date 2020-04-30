/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class MailingListInUserNameException extends PortalException {

	public MailingListInUserNameException() {
	}

	public MailingListInUserNameException(String msg) {
		super(msg);
	}

	public MailingListInUserNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MailingListInUserNameException(Throwable cause) {
		super(cause);
	}

}