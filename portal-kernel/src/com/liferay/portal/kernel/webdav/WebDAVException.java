/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.webdav;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class WebDAVException extends PortalException {

	public WebDAVException() {
	}

	public WebDAVException(String msg) {
		super(msg);
	}

	public WebDAVException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WebDAVException(Throwable cause) {
		super(cause);
	}

}