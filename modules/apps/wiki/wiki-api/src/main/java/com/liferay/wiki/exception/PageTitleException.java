/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class PageTitleException extends PortalException {

	public PageTitleException() {
	}

	public PageTitleException(String msg) {
		super(msg);
	}

	public PageTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PageTitleException(Throwable cause) {
		super(cause);
	}

}