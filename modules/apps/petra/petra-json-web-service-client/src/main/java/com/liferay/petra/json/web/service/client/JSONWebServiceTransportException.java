/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.json.web.service.client;

/**
 * @author Ivica Cardic
 */
public class JSONWebServiceTransportException extends JSONWebServiceException {

	public JSONWebServiceTransportException(String message) {
		super(message);
	}

	public JSONWebServiceTransportException(String message, int status) {
		super(message, status);
	}

	public JSONWebServiceTransportException(String message, Throwable cause) {
		super(message, cause);
	}

	public JSONWebServiceTransportException(Throwable cause) {
		super(cause);
	}

	public static class AuthenticationFailure
		extends JSONWebServiceTransportException {

		public AuthenticationFailure(String message) {
			super(message);
		}

		public AuthenticationFailure(String message, Throwable cause) {
			super(message, cause);
		}

		public AuthenticationFailure(Throwable cause) {
			super(cause);
		}

	}

	public static class CommunicationFailure
		extends JSONWebServiceTransportException {

		public CommunicationFailure(String message, int status) {
			super(message, status);
		}

		public CommunicationFailure(String message, Throwable cause) {
			super(message, cause);
		}

		public CommunicationFailure(Throwable cause) {
			super(cause);
		}

	}

	public static class SigningFailure
		extends JSONWebServiceTransportException {

		public SigningFailure(String message, int status) {
			super(message, status);
		}

		public SigningFailure(String message, Throwable cause) {
			super(message, cause);
		}

		public SigningFailure(Throwable cause) {
			super(cause);
		}

	}

}