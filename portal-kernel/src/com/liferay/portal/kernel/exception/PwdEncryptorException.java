/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Scott Lee
 */
public class PwdEncryptorException extends PortalException {

	public PwdEncryptorException() {
	}

	public PwdEncryptorException(String msg) {
		super(msg);
	}

	public PwdEncryptorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PwdEncryptorException(Throwable cause) {
		super(cause);
	}

}