/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.runtime.client.exception;

/**
 * @author Igor Beslic
 */
public class ConnectionClientException extends ClientException {

	public ConnectionClientException(String message, int httpStatus) {
		super(message, httpStatus);
	}

	public ConnectionClientException(
		String message, int httpStatus, Throwable cause) {

		super(message, httpStatus, cause);
	}

}