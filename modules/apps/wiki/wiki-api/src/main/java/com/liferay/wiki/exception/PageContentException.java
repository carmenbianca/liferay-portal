/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class PageContentException extends PortalException {

	public PageContentException() {
	}

	public PageContentException(String msg) {
		super(msg);
	}

	public PageContentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PageContentException(Throwable cause) {
		super(cause);
	}

}