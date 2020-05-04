/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutNameException extends PortalException {

	public static final int TOO_LONG = 1;

	public static final int TOO_SHORT = 2;

	public LayoutNameException() {
		_type = TOO_SHORT;
	}

	public LayoutNameException(int type) {
		_type = type;
	}

	public LayoutNameException(String msg) {
		super(msg);

		_type = TOO_SHORT;
	}

	public LayoutNameException(String msg, Throwable cause) {
		super(msg, cause);

		_type = TOO_SHORT;
	}

	public LayoutNameException(Throwable cause) {
		super(cause);

		_type = TOO_SHORT;
	}

	public int getType() {
		return _type;
	}

	private final int _type;

}