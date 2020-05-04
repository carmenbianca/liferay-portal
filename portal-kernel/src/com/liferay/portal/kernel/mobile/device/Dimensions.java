/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.mobile.device;

import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Michael C. Han
 */
public class Dimensions implements Serializable {

	public static final Dimensions UNKNOWN = new Dimensions(-1, -1);

	public Dimensions(float height, float width) {
		_height = height;
		_width = width;
	}

	public float getHeight() {
		return _height;
	}

	public float getWidth() {
		return _width;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{height=");
		sb.append(_height);
		sb.append(", width=");
		sb.append(_width);
		sb.append("}");

		return sb.toString();
	}

	private final float _height;
	private final float _width;

}