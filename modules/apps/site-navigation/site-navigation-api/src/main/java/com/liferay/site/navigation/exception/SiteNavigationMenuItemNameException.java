/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SiteNavigationMenuItemNameException extends PortalException {

	public SiteNavigationMenuItemNameException() {
	}

	public SiteNavigationMenuItemNameException(String msg) {
		super(msg);
	}

	public SiteNavigationMenuItemNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SiteNavigationMenuItemNameException(Throwable cause) {
		super(cause);
	}

}