/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Shuyang Zhou
 */
public class PortletContainerException extends PortalException {

	public PortletContainerException() {
	}

	public PortletContainerException(String msg) {
		super(msg);
	}

	public PortletContainerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PortletContainerException(Throwable cause) {
		super(cause);
	}

}