/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lpkg.deployer;

/**
 * @author Shuyang Zhou
 */
public class LPKGVerifyException extends RuntimeException {

	public LPKGVerifyException(String message) {
		super(message);
	}

	public LPKGVerifyException(String message, Throwable cause) {
		super(message, cause);
	}

	public LPKGVerifyException(Throwable cause) {
		super(cause);
	}

}