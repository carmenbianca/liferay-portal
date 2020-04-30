/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.common.exception;

/**
 * @author Zoltán Takács
 */
public class URIPathException extends RuntimeException {

	public URIPathException() {
	}

	public URIPathException(String message) {
		super(message);
	}

	public URIPathException(String message, Throwable cause) {
		super(message, cause);
	}

	public URIPathException(Throwable cause) {
		super(cause);
	}

}