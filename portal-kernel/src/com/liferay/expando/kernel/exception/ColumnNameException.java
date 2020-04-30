/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;

/**
 * @author Brian Wing Shun Chan
 */
public class ColumnNameException extends PortalException {

	public ColumnNameException() {
	}

	public ColumnNameException(String msg) {
		super(msg);
	}

	public ColumnNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ColumnNameException(Throwable cause) {
		super(cause);
	}

	public static class MustValidate extends ColumnNameException {

		public MustValidate() {
			super("Field name must validate with " + Field.class.getName());
		}

	}

}