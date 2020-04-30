/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutBranchNameException extends PortalException {

	public static final int DUPLICATE = 1;

	public static final int TOO_LONG = 2;

	public static final int TOO_SHORT = 3;

	public LayoutBranchNameException(int type) {
		_type = type;
	}

	public int getType() {
		return _type;
	}

	private final int _type;

}