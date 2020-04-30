/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class AntException extends Exception {

	public AntException() {
	}

	public AntException(String message) {
		super(message);
	}

	public AntException(String message, Throwable cause) {
		super(message, cause);
	}

	public AntException(
		String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AntException(Throwable cause) {
		super(cause);
	}

}