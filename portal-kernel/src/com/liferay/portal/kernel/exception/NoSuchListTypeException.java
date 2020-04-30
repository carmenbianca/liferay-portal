/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchListTypeException extends NoSuchModelException {

	public NoSuchListTypeException() {
	}

	public NoSuchListTypeException(String msg) {
		super(msg);
	}

	public NoSuchListTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchListTypeException(Throwable cause) {
		super(cause);
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _type;

}