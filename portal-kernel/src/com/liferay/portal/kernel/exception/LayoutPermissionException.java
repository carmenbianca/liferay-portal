/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutPermissionException extends PortalException {

	public LayoutPermissionException() {
	}

	public LayoutPermissionException(String msg) {
		super(msg);
	}

	public LayoutPermissionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LayoutPermissionException(Throwable cause) {
		super(cause);
	}

}