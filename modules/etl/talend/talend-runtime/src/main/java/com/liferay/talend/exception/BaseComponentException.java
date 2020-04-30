/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.exception;

/**
 * @author Igor Beslic
 */
public class BaseComponentException extends RuntimeException {

	public BaseComponentException(String message, int httpStatus) {
		super(message);

		_httpStatus = httpStatus;
	}

	public BaseComponentException(
		String message, int httpStatus, Throwable cause) {

		super(message, cause);

		_httpStatus = httpStatus;
	}

	public int getHttpStatus() {
		return _httpStatus;
	}

	private final int _httpStatus;

}