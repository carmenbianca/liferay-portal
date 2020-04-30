/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Ryan Park
 */
public class NoSuchModuleException extends NoSuchModelException {

	public NoSuchModuleException() {
	}

	public NoSuchModuleException(String msg) {
		super(msg);
	}

	public NoSuchModuleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchModuleException(Throwable cause) {
		super(cause);
	}

}