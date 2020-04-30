/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Adolfo Pérez
 */
public class NoSuchClassTypeException extends NoSuchModelException {

	public NoSuchClassTypeException() {
	}

	public NoSuchClassTypeException(String msg) {
		super(msg);
	}

	public NoSuchClassTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchClassTypeException(Throwable cause) {
		super(cause);
	}

}