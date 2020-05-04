/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.json.web.service.client;

/**
 * @author Ivica Cardic
 * @author Igor Beslic
 */
public class JSONWebServiceInvocationException extends JSONWebServiceException {

	public JSONWebServiceInvocationException(String message) {
		super(message);
	}

	public JSONWebServiceInvocationException(String message, int status) {
		super(message, status);
	}

	public JSONWebServiceInvocationException(
		String message, int status, Throwable cause) {

		super(message, status, cause);
	}

	public JSONWebServiceInvocationException(String message, Throwable cause) {
		super(message, cause);
	}

	public JSONWebServiceInvocationException(Throwable cause) {
		super(cause);
	}

}