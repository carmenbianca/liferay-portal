/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.log;

/**
 * @author Tomas Polesovsky
 */
public class LogSanitizerException extends Exception {

	public LogSanitizerException() {
	}

	public LogSanitizerException(String message) {
		super(message);
	}

	public LogSanitizerException(
		String message, StackTraceElement[] stackTraceElements,
		Throwable throwable) {

		super(message, throwable);

		setStackTrace(stackTraceElements);
	}

	public LogSanitizerException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public LogSanitizerException(Throwable throwable) {
		super(throwable);
	}

	@Override
	public String toString() {
		String localizedMessage = getLocalizedMessage();

		if (localizedMessage != null) {
			return localizedMessage;
		}

		Class<?> clazz = getClass();

		return clazz.getName();
	}

}