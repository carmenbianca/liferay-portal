/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scripting;

/**
 * @author Alberto Montero
 * @author Brian Wing Shun Chan
 */
public class UnsupportedLanguageException extends ScriptingException {

	public UnsupportedLanguageException() {
	}

	public UnsupportedLanguageException(String msg) {
		super(msg);
	}

	public UnsupportedLanguageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UnsupportedLanguageException(Throwable cause) {
		super(cause);
	}

}