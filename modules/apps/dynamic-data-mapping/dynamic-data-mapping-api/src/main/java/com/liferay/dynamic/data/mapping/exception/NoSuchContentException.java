/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchContentException extends NoSuchModelException {

	public NoSuchContentException() {
	}

	public NoSuchContentException(String msg) {
		super(msg);
	}

	public NoSuchContentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchContentException(Throwable cause) {
		super(cause);
	}

}