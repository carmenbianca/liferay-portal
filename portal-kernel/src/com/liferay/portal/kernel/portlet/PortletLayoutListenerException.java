/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletLayoutListenerException extends RuntimeException {

	public PortletLayoutListenerException() {
	}

	public PortletLayoutListenerException(String msg) {
		super(msg);
	}

	public PortletLayoutListenerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PortletLayoutListenerException(Throwable cause) {
		super(cause);
	}

}