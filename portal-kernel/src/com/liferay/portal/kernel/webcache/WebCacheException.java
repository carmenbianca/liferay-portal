/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.webcache;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class WebCacheException extends PortalException {

	public WebCacheException() {
	}

	public WebCacheException(String msg) {
		super(msg);
	}

	public WebCacheException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WebCacheException(Throwable cause) {
		super(cause);
	}

}