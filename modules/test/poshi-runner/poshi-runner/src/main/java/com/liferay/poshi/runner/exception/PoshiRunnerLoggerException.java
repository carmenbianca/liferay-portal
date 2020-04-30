/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.exception;

/**
 * @author Kevin Yen
 */
public class PoshiRunnerLoggerException extends Exception {

	public PoshiRunnerLoggerException() {
	}

	public PoshiRunnerLoggerException(String msg) {
		super(msg);
	}

	public PoshiRunnerLoggerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PoshiRunnerLoggerException(Throwable cause) {
		super(cause);
	}

}