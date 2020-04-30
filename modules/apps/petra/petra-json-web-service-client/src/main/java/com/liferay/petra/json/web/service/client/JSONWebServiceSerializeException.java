/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.json.web.service.client;

/**
 * @author Igor Beslic
 */
public class JSONWebServiceSerializeException extends JSONWebServiceException {

	public JSONWebServiceSerializeException(String message) {
		super(message);
	}

	public JSONWebServiceSerializeException(String message, Throwable cause) {
		super(message, cause);
	}

	public JSONWebServiceSerializeException(Throwable cause) {
		super(cause);
	}

}