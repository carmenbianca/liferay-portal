/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class SitemapPagePriorityException extends PortalException {

	public SitemapPagePriorityException() {
	}

	public SitemapPagePriorityException(String msg) {
		super(msg);
	}

	public SitemapPagePriorityException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SitemapPagePriorityException(Throwable cause) {
		super(cause);
	}

}