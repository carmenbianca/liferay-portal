/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchMenuItemException extends NoSuchModelException {

	public NoSuchMenuItemException() {
	}

	public NoSuchMenuItemException(String msg) {
		super(msg);
	}

	public NoSuchMenuItemException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchMenuItemException(Throwable cause) {
		super(cause);
	}

}