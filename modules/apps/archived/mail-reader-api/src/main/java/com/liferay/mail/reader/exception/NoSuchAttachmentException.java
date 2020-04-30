/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAttachmentException extends NoSuchModelException {

	public NoSuchAttachmentException() {
	}

	public NoSuchAttachmentException(String msg) {
		super(msg);
	}

	public NoSuchAttachmentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAttachmentException(Throwable cause) {
		super(cause);
	}

}