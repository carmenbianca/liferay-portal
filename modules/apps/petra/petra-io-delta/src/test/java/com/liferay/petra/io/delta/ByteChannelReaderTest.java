/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.io.delta;

import java.io.IOException;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

import org.junit.Test;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * @author Dennis Ju
 */
public class ByteChannelReaderTest {

	@Test
	public void testRead() throws IOException {
		ReadableByteChannel readableByteChannel = Mockito.mock(
			ReadableByteChannel.class);

		int length = 128;

		ByteChannelReader byteChannelReader = new ByteChannelReader(
			readableByteChannel, length);

		final ByteBuffer byteBuffer = byteChannelReader.getBuffer();

		Answer answer = new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocationOnMock)
				throws Throwable {

				int bytesRead = byteBuffer.remaining();

				if (_partialRead) {
					bytesRead--;
				}

				byteBuffer.put(new byte[bytesRead], 0, bytesRead);

				_partialRead = !_partialRead;

				return bytesRead;
			}

			private boolean _partialRead = true;

		};

		Mockito.when(
			readableByteChannel.read(byteBuffer)
		).then(
			answer
		);

		int remainingData = 1025;

		while (remainingData > 0) {
			if (remainingData > length) {
				remainingData -= length;
			}
			else {
				length = remainingData;

				remainingData = 0;
			}

			byteChannelReader.ensureData(length);

			byteBuffer.get(new byte[length]);
		}
	}

}