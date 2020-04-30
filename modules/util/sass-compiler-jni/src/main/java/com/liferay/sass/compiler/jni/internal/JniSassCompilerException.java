/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sass.compiler.jni.internal;

import com.liferay.sass.compiler.SassCompilerException;

/**
 * @author Gregory Amerson
 */
public class JniSassCompilerException extends SassCompilerException {

	public JniSassCompilerException() {
	}

	public JniSassCompilerException(String message) {
		super(message);
	}

	public JniSassCompilerException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public JniSassCompilerException(Throwable throwable) {
		super(throwable);
	}

}