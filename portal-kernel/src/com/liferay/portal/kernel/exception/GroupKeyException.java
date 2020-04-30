/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class GroupKeyException extends PortalException {

	public GroupKeyException() {
	}

	public GroupKeyException(String msg) {
		super(msg);
	}

	public GroupKeyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public GroupKeyException(Throwable cause) {
		super(cause);
	}

}