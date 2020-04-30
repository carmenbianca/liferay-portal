/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEntryLinkException extends NoSuchModelException {

	public NoSuchEntryLinkException() {
	}

	public NoSuchEntryLinkException(String msg) {
		super(msg);
	}

	public NoSuchEntryLinkException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEntryLinkException(Throwable cause) {
		super(cause);
	}

}