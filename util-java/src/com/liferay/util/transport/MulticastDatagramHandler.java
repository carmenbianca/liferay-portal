/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.transport;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;

import java.io.InputStream;

import java.net.DatagramPacket;

import java.util.zip.GZIPInputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Michael C. Han
 * @author Raymond Augé
 */
public class MulticastDatagramHandler implements DatagramHandler {

	public MulticastDatagramHandler(boolean gzipData, boolean shortData) {
		_gzipData = gzipData;
		_shortData = shortData;
	}

	@Override
	public void errorReceived(Throwable t) {
		_log.error(t, t);
	}

	@Override
	public void process(DatagramPacket packet) {
		byte[] bytes = packet.getData();

		if (_gzipData) {
			try {
				bytes = getUnzippedBytes(bytes);
			}
			catch (Exception exception) {
				_log.error(exception, exception);
			}
		}

		if (_shortData) {
			byte[] temp = new byte[96];

			System.arraycopy(bytes, 0, temp, 0, 96);

			bytes = temp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append("[");
		sb.append(packet.getSocketAddress());
		sb.append("] ");
		sb.append(new String(bytes));

		if (_log.isInfoEnabled()) {
			_log.info(sb.toString());
		}
	}

	protected byte[] getUnzippedBytes(byte[] bytes) throws Exception {
		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream(bytes.length);

		try (InputStream is = new GZIPInputStream(
				new UnsyncByteArrayInputStream(bytes))) {

			byte[] buffer = new byte[1500];
			int c = 0;

			while (true) {
				if (c == -1) {
					break;
				}

				c = is.read(buffer, 0, 1500);

				if (c != -1) {
					unsyncByteArrayOutputStream.write(buffer, 0, c);
				}
			}
		}

		unsyncByteArrayOutputStream.flush();
		unsyncByteArrayOutputStream.close();

		return unsyncByteArrayOutputStream.toByteArray();
	}

	private static final Log _log = LogFactory.getLog(
		MulticastDatagramHandler.class);

	private final boolean _gzipData;
	private final boolean _shortData;

}