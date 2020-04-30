/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sass.compiler.jsass.internal;

import com.liferay.sass.compiler.SassCompilerException;

/**
 * @author David Truong
 */
public class JSassCompilerException extends SassCompilerException {

	public JSassCompilerException() {
	}

	public JSassCompilerException(String message) {
		super(message);
	}

	public JSassCompilerException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public JSassCompilerException(Throwable throwable) {
		super(throwable);
	}

}