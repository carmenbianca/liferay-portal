/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @see    com.liferay.portal.kernel.servlet.NonSerializableObjectHandler
 */
public class TransientValue<V> implements Serializable {

	public TransientValue() {
	}

	public TransientValue(V value) {
		_value = value;
	}

	public V getValue() {
		return _value;
	}

	public boolean isNotNull() {
		return !isNull();
	}

	public boolean isNull() {
		if (_value == null) {
			return true;
		}

		return false;
	}

	public void setValue(V value) {
		_value = value;
	}

	private transient V _value;

}