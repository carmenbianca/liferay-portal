/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAppCustomizationException extends NoSuchModelException {

	public NoSuchAppCustomizationException() {
	}

	public NoSuchAppCustomizationException(String msg) {
		super(msg);
	}

	public NoSuchAppCustomizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAppCustomizationException(Throwable cause) {
		super(cause);
	}

}