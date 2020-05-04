/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.io.unsync;

import java.io.IOException;
import java.io.OutputStream;

/**
 * <p>
 * See https://issues.liferay.com/browse/LPS-6648.
 * </p>
 *
 * @author Shuyang Zhou
 */
public class UnsyncFilterOutputStream extends OutputStream {

	public UnsyncFilterOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	@Override
	public void close() throws IOException {
		try (OutputStream os = outputStream) {
			flush();
		}
	}

	@Override
	public void flush() throws IOException {
		outputStream.flush();
	}

	@Override
	public void write(byte[] bytes) throws IOException {
		write(bytes, 0, bytes.length);
	}

	@Override
	public void write(byte[] bytes, int offset, int length) throws IOException {
		outputStream.write(bytes, offset, length);
	}

	@Override
	public void write(int b) throws IOException {
		outputStream.write(b);
	}

	protected OutputStream outputStream;

}