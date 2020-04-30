/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.json;

/**
 * @author Brian Wing Shun Chan
 */
public class JSONObjectWrapper {

	public JSONObjectWrapper(Object value) {
		_value = value;
	}

	public Object getValue() {
		return _value;
	}

	private final Object _value;

}