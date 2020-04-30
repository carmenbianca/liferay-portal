/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.data.partitioning.sql.builder.exporter.exception;

/**
 * @author Miguel Pastor
 */
public class DBProviderNotAvailableException extends RuntimeException {

	public DBProviderNotAvailableException() {
	}

	public DBProviderNotAvailableException(String message) {
		super(message);
	}

	public DBProviderNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBProviderNotAvailableException(
		String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DBProviderNotAvailableException(Throwable cause) {
		super(cause);
	}

}