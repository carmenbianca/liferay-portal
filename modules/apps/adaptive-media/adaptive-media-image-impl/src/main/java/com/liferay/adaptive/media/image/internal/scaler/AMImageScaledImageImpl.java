/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.internal.scaler;

import com.liferay.adaptive.media.image.scaler.AMImageScaledImage;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;

import java.io.InputStream;

/**
 * @author Sergio González
 */
public class AMImageScaledImageImpl implements AMImageScaledImage {

	public AMImageScaledImageImpl(byte[] bytes, int height, int width) {
		_bytes = bytes;
		_height = height;
		_width = width;
	}

	@Override
	public int getHeight() {
		return _height;
	}

	@Override
	public InputStream getInputStream() {
		return new UnsyncByteArrayInputStream(_bytes);
	}

	@Override
	public long getSize() {
		return _bytes.length;
	}

	@Override
	public int getWidth() {
		return _width;
	}

	private final byte[] _bytes;
	private final int _height;
	private final int _width;

}