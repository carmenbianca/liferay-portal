/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletIdException extends PortalException {

	public PortletIdException() {
	}

	public PortletIdException(String msg) {
		super(msg);
	}

	public PortletIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PortletIdException(Throwable cause) {
		super(cause);
	}

}