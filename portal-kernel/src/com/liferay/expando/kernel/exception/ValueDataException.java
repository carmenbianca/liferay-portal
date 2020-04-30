/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ValueDataException extends PortalException {

	public ValueDataException() {
	}

	public ValueDataException(String msg) {
		super(msg);
	}

	public ValueDataException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ValueDataException(Throwable cause) {
		super(cause);
	}

}