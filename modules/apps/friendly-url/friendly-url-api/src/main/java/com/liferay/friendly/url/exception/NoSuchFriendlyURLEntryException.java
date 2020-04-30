/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.friendly.url.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFriendlyURLEntryException extends NoSuchModelException {

	public NoSuchFriendlyURLEntryException() {
	}

	public NoSuchFriendlyURLEntryException(String msg) {
		super(msg);
	}

	public NoSuchFriendlyURLEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFriendlyURLEntryException(Throwable cause) {
		super(cause);
	}

}