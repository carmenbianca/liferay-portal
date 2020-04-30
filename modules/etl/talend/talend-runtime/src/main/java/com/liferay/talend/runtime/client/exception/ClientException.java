/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.runtime.client.exception;

import com.liferay.talend.exception.BaseComponentException;

/**
 * @author Igor Beslic
 */
public class ClientException extends BaseComponentException {

	public ClientException(String message) {
		super(message, 0);
	}

	public ClientException(String message, int httpStatus) {
		super(message, httpStatus);
	}

	public ClientException(String message, int httpStatus, Throwable cause) {
		super(message, httpStatus, cause);
	}

}