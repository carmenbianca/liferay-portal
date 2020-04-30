/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSiteException extends NoSuchModelException {

	public NoSuchSiteException() {
	}

	public NoSuchSiteException(String msg) {
		super(msg);
	}

	public NoSuchSiteException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSiteException(Throwable cause) {
		super(cause);
	}

}