/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchDataProviderInstanceException extends NoSuchModelException {

	public NoSuchDataProviderInstanceException() {
	}

	public NoSuchDataProviderInstanceException(String msg) {
		super(msg);
	}

	public NoSuchDataProviderInstanceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchDataProviderInstanceException(Throwable cause) {
		super(cause);
	}

}