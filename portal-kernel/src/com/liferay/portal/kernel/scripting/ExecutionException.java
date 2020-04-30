/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scripting;

/**
 * @author Alberto Montero
 * @author Brian Wing Shun Chan
 */
public class ExecutionException extends ScriptingException {

	public ExecutionException() {
	}

	public ExecutionException(String msg) {
		super(msg);
	}

	public ExecutionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ExecutionException(Throwable cause) {
		super(cause);
	}

}