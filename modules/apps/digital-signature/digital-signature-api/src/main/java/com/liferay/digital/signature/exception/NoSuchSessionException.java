/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.exception;

/**
 * @author Michael C. Han
 */
public class NoSuchSessionException extends DSSignatureException {

	public NoSuchSessionException(String message) {
		super(message);
	}

	public NoSuchSessionException(String message, Throwable cause) {
		super(message, cause);
	}

}