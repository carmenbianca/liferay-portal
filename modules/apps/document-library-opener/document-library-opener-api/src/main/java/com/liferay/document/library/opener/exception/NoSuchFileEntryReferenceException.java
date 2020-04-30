/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.opener.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFileEntryReferenceException extends NoSuchModelException {

	public NoSuchFileEntryReferenceException() {
	}

	public NoSuchFileEntryReferenceException(String msg) {
		super(msg);
	}

	public NoSuchFileEntryReferenceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFileEntryReferenceException(Throwable cause) {
		super(cause);
	}

}