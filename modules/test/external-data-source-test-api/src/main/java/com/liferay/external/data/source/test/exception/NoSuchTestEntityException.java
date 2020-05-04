/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.external.data.source.test.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTestEntityException extends NoSuchModelException {

	public NoSuchTestEntityException() {
	}

	public NoSuchTestEntityException(String msg) {
		super(msg);
	}

	public NoSuchTestEntityException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTestEntityException(Throwable cause) {
		super(cause);
	}

}