/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAMImageEntryException extends NoSuchModelException {

	public NoSuchAMImageEntryException() {
	}

	public NoSuchAMImageEntryException(String msg) {
		super(msg);
	}

	public NoSuchAMImageEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAMImageEntryException(Throwable cause) {
		super(cause);
	}

}