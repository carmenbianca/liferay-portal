/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchDataListViewException extends NoSuchModelException {

	public NoSuchDataListViewException() {
	}

	public NoSuchDataListViewException(String msg) {
		super(msg);
	}

	public NoSuchDataListViewException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchDataListViewException(Throwable cause) {
		super(cause);
	}

}