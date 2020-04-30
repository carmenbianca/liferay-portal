/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicatePageException extends PortalException {

	public DuplicatePageException() {
	}

	public DuplicatePageException(String msg) {
		super(msg);
	}

	public DuplicatePageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicatePageException(Throwable cause) {
		super(cause);
	}

}