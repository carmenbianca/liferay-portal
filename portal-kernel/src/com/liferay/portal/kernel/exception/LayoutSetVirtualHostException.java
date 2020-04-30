/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutSetVirtualHostException extends PortalException {

	public LayoutSetVirtualHostException() {
	}

	public LayoutSetVirtualHostException(String msg) {
		super(msg);
	}

	public LayoutSetVirtualHostException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LayoutSetVirtualHostException(Throwable cause) {
		super(cause);
	}

}