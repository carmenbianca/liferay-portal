/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.scaler;

import java.io.InputStream;

/**
 * Represents an image scaled by Adaptive Media.
 *
 * @author Sergio González
 */
public interface AMImageScaledImage {

	/**
	 * Returns the image height.
	 *
	 * @return the image height
	 */
	public int getHeight();

	/**
	 * Returns an <code>InputStream</code> with the image data.
	 *
	 * @return the <code>InputStream</code> with the image data
	 */
	public InputStream getInputStream();

	/**
	 * Returns this image's size in bytes.
	 *
	 * @return this image's size in bytes
	 */
	public long getSize();

	/**
	 * Returns the image width.
	 *
	 * @return the image width
	 */
	public int getWidth();

}