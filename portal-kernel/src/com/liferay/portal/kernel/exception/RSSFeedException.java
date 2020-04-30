/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class RSSFeedException extends PortalException {

	public RSSFeedException() {
	}

	public RSSFeedException(String msg) {
		super(msg);
	}

	public RSSFeedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RSSFeedException(Throwable cause) {
		super(cause);
	}

}