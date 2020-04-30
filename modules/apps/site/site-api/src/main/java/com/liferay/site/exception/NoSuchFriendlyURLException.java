/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFriendlyURLException extends NoSuchModelException {

	public NoSuchFriendlyURLException() {
	}

	public NoSuchFriendlyURLException(String msg) {
		super(msg);
	}

	public NoSuchFriendlyURLException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFriendlyURLException(Throwable cause) {
		super(cause);
	}

}