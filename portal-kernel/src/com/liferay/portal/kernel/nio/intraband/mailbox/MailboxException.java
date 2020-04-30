/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband.mailbox;

/**
 * @author Shuyang Zhou
 */
public class MailboxException extends Exception {

	public MailboxException() {
	}

	public MailboxException(String message) {
		super(message);
	}

	public MailboxException(String message, Throwable cause) {
		super(message, cause);
	}

	public MailboxException(Throwable cause) {
		super(cause);
	}

}