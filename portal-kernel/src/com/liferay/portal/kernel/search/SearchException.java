/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchException extends PortalException {

	public SearchException() {
	}

	public SearchException(String msg) {
		super(msg);
	}

	public SearchException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SearchException(Throwable cause) {
		super(cause);
	}

}