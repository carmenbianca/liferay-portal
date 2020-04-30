/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.runtime.client.exception;

/**
 * @author Igor Beslic
 */
public class RemoteExecutionClientException extends ClientException {

	public RemoteExecutionClientException(String message, int httpStatus) {
		super(message, httpStatus);
	}

}