/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class PageVersionException extends PortalException {

	public PageVersionException() {
	}

	public PageVersionException(String msg) {
		super(msg);
	}

	public PageVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PageVersionException(Throwable cause) {
		super(cause);
	}

}