/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SiteNavigationMenuNameException extends PortalException {

	public SiteNavigationMenuNameException() {
	}

	public SiteNavigationMenuNameException(String msg) {
		super(msg);
	}

	public SiteNavigationMenuNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SiteNavigationMenuNameException(Throwable cause) {
		super(cause);
	}

}