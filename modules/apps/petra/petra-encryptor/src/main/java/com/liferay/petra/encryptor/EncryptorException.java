/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.encryptor;

/**
 * @author Brian Wing Shun Chan
 * @see    com.liferay.util.EncryptorException
 */
public class EncryptorException extends Exception {

	public EncryptorException() {
	}

	public EncryptorException(String msg) {
		super(msg);
	}

	public EncryptorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EncryptorException(Throwable cause) {
		super(cause);
	}

}