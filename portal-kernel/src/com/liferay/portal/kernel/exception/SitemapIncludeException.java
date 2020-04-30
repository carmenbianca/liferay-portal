/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class SitemapIncludeException extends PortalException {

	public SitemapIncludeException() {
	}

	public SitemapIncludeException(String msg) {
		super(msg);
	}

	public SitemapIncludeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SitemapIncludeException(Throwable cause) {
		super(cause);
	}

}