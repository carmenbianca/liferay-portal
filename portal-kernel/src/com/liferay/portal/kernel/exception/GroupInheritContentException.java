/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class GroupInheritContentException extends PortalException {

	public GroupInheritContentException() {
	}

	public GroupInheritContentException(String msg) {
		super(msg);
	}

	public GroupInheritContentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public GroupInheritContentException(Throwable cause) {
		super(cause);
	}

}