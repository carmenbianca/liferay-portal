/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Adolfo Pérez
 */
public class NoSuchClassTypeFieldException extends NoSuchModelException {

	public NoSuchClassTypeFieldException() {
	}

	public NoSuchClassTypeFieldException(String msg) {
		super(msg);
	}

	public NoSuchClassTypeFieldException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchClassTypeFieldException(Throwable cause) {
		super(cause);
	}

}