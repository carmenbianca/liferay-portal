/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCollectionException extends NoSuchModelException {

	public NoSuchCollectionException() {
	}

	public NoSuchCollectionException(String msg) {
		super(msg);
	}

	public NoSuchCollectionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCollectionException(Throwable cause) {
		super(cause);
	}

}