/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.mail;

import com.liferay.portal.kernel.exception.NestableException;

/**
 * @author Brian Wing Shun Chan
 * @see    com.liferay.util.mail.MailEngineException
 */
public class MailEngineException extends NestableException {

	public MailEngineException() {
	}

	public MailEngineException(String msg) {
		super(msg);
	}

	public MailEngineException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MailEngineException(Throwable cause) {
		super(cause);
	}

}