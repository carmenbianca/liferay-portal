/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.petra.string.StringPool;

import java.lang.reflect.Field;

/**
 * @author Shuyang Zhou
 */
public class ReferenceEntry {

	public ReferenceEntry(Field field) {
		this(null, field);
	}

	public ReferenceEntry(Object object, Field field) {
		_object = object;

		_field = field;

		_field.setAccessible(true);
	}

	public Field getField() {
		return _field;
	}

	public Object getObject() {
		return _object;
	}

	public void setValue(Object value)
		throws IllegalAccessException, IllegalArgumentException {

		_field.set(_object, value);
	}

	@Override
	public String toString() {
		return _object.toString(
		).concat(
			StringPool.POUND
		).concat(
			_field.toString()
		);
	}

	private final Field _field;
	private final Object _object;

}