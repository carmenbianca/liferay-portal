/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateSiteNavigationMenuException extends PortalException {

	public DuplicateSiteNavigationMenuException() {
	}

	public DuplicateSiteNavigationMenuException(String msg) {
		super(msg);
	}

	public DuplicateSiteNavigationMenuException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateSiteNavigationMenuException(Throwable cause) {
		super(cause);
	}

}