/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.css.builder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.nio.charset.Charset;

/**
 * @author Christopher Bryan Boyd
 */
public class StringPrintStream extends PrintStream {

	public StringPrintStream() {
		this(new ByteArrayOutputStream(), Charset.defaultCharset());
	}

	public StringPrintStream(
		ByteArrayOutputStream byteArrayOutputStream, Charset charset) {

		super(byteArrayOutputStream);

		_byteArrayOutputStream = byteArrayOutputStream;
	}

	@Override
	public String toString() {
		return new String(_byteArrayOutputStream.toByteArray());
	}

	private ByteArrayOutputStream _byteArrayOutputStream;

}