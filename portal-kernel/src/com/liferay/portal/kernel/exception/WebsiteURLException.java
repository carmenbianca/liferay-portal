/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class WebsiteURLException extends PortalException {

	public WebsiteURLException() {
	}

	public WebsiteURLException(String msg) {
		super(msg);
	}

	public WebsiteURLException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WebsiteURLException(Throwable cause) {
		super(cause);
	}

}