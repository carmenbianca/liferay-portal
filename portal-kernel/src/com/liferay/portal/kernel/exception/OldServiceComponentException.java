/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class OldServiceComponentException extends PortalException {

	public OldServiceComponentException() {
	}

	public OldServiceComponentException(String msg) {
		super(msg);
	}

	public OldServiceComponentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OldServiceComponentException(Throwable cause) {
		super(cause);
	}

}