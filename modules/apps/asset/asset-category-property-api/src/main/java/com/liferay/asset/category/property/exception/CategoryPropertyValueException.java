/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.category.property.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class CategoryPropertyValueException extends PortalException {

	public CategoryPropertyValueException() {
	}

	public CategoryPropertyValueException(String msg) {
		super(msg);
	}

	public CategoryPropertyValueException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CategoryPropertyValueException(Throwable cause) {
		super(cause);
	}

}