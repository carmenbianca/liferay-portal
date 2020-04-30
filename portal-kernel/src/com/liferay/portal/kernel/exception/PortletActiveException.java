/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletActiveException extends PortalException {

	public PortletActiveException() {
	}

	public PortletActiveException(String msg) {
		super(msg);
	}

	public PortletActiveException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PortletActiveException(Throwable cause) {
		super(cause);
	}

}