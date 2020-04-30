/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sass.compiler.ruby.internal;

import com.liferay.sass.compiler.SassCompilerException;

/**
 * @author David Truong
 */
public class RubySassCompilerException extends SassCompilerException {

	public RubySassCompilerException() {
	}

	public RubySassCompilerException(String message) {
		super(message);
	}

	public RubySassCompilerException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public RubySassCompilerException(Throwable throwable) {
		super(throwable);
	}

}