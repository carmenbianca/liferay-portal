/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

/**
 * @author Brian Wing Shun Chan
 */
public class ArrayWrapper {

	public ArrayWrapper() {
	}

	public Object[] getArray() {
		return _array;
	}

	public void setArray(Object[] array) {
		_array = array;
	}

	private Object[] _array;

}