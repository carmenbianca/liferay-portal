/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateCategoryPropertyException extends PortalException {

	public DuplicateCategoryPropertyException() {
	}

	public DuplicateCategoryPropertyException(String msg) {
		super(msg);
	}

	public DuplicateCategoryPropertyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateCategoryPropertyException(Throwable cause) {
		super(cause);
	}

}