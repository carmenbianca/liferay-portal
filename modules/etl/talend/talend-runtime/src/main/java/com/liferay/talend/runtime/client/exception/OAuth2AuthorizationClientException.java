/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.runtime.client.exception;

/**
 * @author Igor Beslic
 */
public class OAuth2AuthorizationClientException extends ClientException {

	public OAuth2AuthorizationClientException(String message) {
		super(message);
	}

	public OAuth2AuthorizationClientException(String message, int httpStatus) {
		super(message, httpStatus);
	}

}