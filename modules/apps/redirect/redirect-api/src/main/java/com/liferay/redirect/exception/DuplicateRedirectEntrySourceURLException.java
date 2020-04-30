/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateRedirectEntrySourceURLException extends PortalException {

	public DuplicateRedirectEntrySourceURLException() {
	}

	public DuplicateRedirectEntrySourceURLException(String msg) {
		super(msg);
	}

	public DuplicateRedirectEntrySourceURLException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public DuplicateRedirectEntrySourceURLException(Throwable cause) {
		super(cause);
	}

}