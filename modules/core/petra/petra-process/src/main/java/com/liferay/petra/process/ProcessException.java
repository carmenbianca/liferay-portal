/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.process;

/**
 * @author Shuyang Zhou
 */
public class ProcessException extends Exception {

	public ProcessException(String message) {
		super(message);
	}

	public ProcessException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProcessException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}