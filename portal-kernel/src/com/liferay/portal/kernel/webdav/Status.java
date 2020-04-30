/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.webdav;

/**
 * @author Brian Wing Shun Chan
 */
public class Status {

	public Status(int code) {
		this(null, code);
	}

	public Status(Object object, int code) {
		_object = object;
		_code = code;
	}

	public int getCode() {
		return _code;
	}

	public Object getObject() {
		return _object;
	}

	private final int _code;
	private final Object _object;

}