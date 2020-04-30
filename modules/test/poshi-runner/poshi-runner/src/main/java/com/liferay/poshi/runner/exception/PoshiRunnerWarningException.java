/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class PoshiRunnerWarningException extends Exception {

	public PoshiRunnerWarningException() {
	}

	public PoshiRunnerWarningException(String msg) {
		super(msg);
	}

	public PoshiRunnerWarningException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PoshiRunnerWarningException(Throwable cause) {
		super(cause);
	}

}