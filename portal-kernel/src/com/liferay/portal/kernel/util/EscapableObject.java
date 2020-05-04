/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.io.Serializable;

/**
 * @author Jonathan Potter
 * @author Brian Wing Shun Chan
 */
public class EscapableObject<T> implements Serializable {

	public EscapableObject(T originalValue) {
		this(originalValue, true);
	}

	public EscapableObject(T originalValue, boolean escape) {
		_originalValue = originalValue;
		_escape = escape;
	}

	public String getEscapedValue() {
		if (_escapedValue == null) {
			if (_escape) {
				_escapedValue = escape(_originalValue);
			}
			else {
				_escapedValue = String.valueOf(_originalValue);
			}
		}

		return _escapedValue;
	}

	public T getOriginalValue() {
		return _originalValue;
	}

	public boolean isEscape() {
		return _escape;
	}

	@Override
	public String toString() {
		return _originalValue.toString();
	}

	protected String escape(T t) {
		return String.valueOf(t);
	}

	private final boolean _escape;
	private String _escapedValue;
	private final T _originalValue;

}