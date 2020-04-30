/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class RequiredRedirectEntrySourceURLException extends PortalException {

	public RequiredRedirectEntrySourceURLException() {
	}

	public RequiredRedirectEntrySourceURLException(String msg) {
		super(msg);
	}

	public RequiredRedirectEntrySourceURLException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public RequiredRedirectEntrySourceURLException(Throwable cause) {
		super(cause);
	}

}