/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class CategoryPropertyKeyException extends PortalException {

	public CategoryPropertyKeyException() {
	}

	public CategoryPropertyKeyException(String msg) {
		super(msg);
	}

	public CategoryPropertyKeyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CategoryPropertyKeyException(Throwable cause) {
		super(cause);
	}

}