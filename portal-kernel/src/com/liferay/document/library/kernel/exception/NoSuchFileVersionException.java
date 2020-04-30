/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFileVersionException extends NoSuchModelException {

	public NoSuchFileVersionException() {
	}

	public NoSuchFileVersionException(String msg) {
		super(msg);
	}

	public NoSuchFileVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchFileVersionException(Throwable cause) {
		super(cause);
	}

}