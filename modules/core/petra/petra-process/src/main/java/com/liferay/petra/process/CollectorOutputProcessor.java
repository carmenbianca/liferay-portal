/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.process;

import com.liferay.petra.io.StreamUtil;
import com.liferay.petra.io.unsync.UnsyncByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Shuyang Zhou
 */
public class CollectorOutputProcessor
	implements OutputProcessor<byte[], byte[]> {

	public static final OutputProcessor<byte[], byte[]> INSTANCE =
		new CollectorOutputProcessor();

	@Override
	public byte[] processStdErr(InputStream stdErrInputStream)
		throws ProcessException {

		return _collect(stdErrInputStream);
	}

	@Override
	public byte[] processStdOut(InputStream stdOutInputStream)
		throws ProcessException {

		return _collect(stdOutInputStream);
	}

	private byte[] _collect(InputStream inputStream) throws ProcessException {
		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream();

		try {
			StreamUtil.transfer(inputStream, unsyncByteArrayOutputStream);
		}
		catch (IOException ioException) {
			throw new ProcessException(ioException);
		}

		return unsyncByteArrayOutputStream.toByteArray();
	}

}