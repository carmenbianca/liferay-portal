/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiFormatException extends PortalException {

	public WikiFormatException() {
	}

	public WikiFormatException(String msg) {
		super(msg);
	}

	public WikiFormatException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WikiFormatException(Throwable cause) {
		super(cause);
	}

}