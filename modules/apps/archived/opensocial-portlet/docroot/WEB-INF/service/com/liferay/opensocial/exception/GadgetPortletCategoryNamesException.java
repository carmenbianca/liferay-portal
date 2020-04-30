/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class GadgetPortletCategoryNamesException extends PortalException {

	public GadgetPortletCategoryNamesException() {
	}

	public GadgetPortletCategoryNamesException(String msg) {
		super(msg);
	}

	public GadgetPortletCategoryNamesException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public GadgetPortletCategoryNamesException(Throwable cause) {
		super(cause);
	}

}