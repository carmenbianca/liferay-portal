/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchStructureLayoutException extends NoSuchModelException {

	public NoSuchStructureLayoutException() {
	}

	public NoSuchStructureLayoutException(String msg) {
		super(msg);
	}

	public NoSuchStructureLayoutException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchStructureLayoutException(Throwable cause) {
		super(cause);
	}

}