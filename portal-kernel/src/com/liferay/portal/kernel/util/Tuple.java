/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.io.Serializable;

import java.util.Arrays;

/**
 * @author Alexander Chow
 */
public class Tuple implements Serializable {

	public Tuple(Object... array) {
		_array = array;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Tuple)) {
			return false;
		}

		Tuple tuple = (Tuple)obj;

		return Arrays.equals(_array, tuple._array);
	}

	public Object getObject(int i) {
		return _array[i];
	}

	public int getSize() {
		return _array.length;
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(_array);
	}

	@Override
	public String toString() {
		return Arrays.toString(_array);
	}

	private final Object[] _array;

}