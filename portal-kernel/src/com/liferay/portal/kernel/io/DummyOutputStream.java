/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.io;

import java.io.OutputStream;

/**
 * @author Brian Wing Shun Chan
 */
public class DummyOutputStream extends OutputStream {

	@Override
	public void close() {
	}

	@Override
	public void flush() {
	}

	@Override
	public void write(byte[] bytes) {
	}

	@Override
	public void write(byte[] bytes, int offset, int length) {
	}

	@Override
	public void write(int b) {
	}

}