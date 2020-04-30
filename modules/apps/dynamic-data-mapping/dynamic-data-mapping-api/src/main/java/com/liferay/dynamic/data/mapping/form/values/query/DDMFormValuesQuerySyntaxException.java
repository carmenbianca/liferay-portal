/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.values.query;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Adolfo Pérez
 */
public class DDMFormValuesQuerySyntaxException extends PortalException {

	public DDMFormValuesQuerySyntaxException() {
	}

	public DDMFormValuesQuerySyntaxException(String msg) {
		super(msg);
	}

	public DDMFormValuesQuerySyntaxException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DDMFormValuesQuerySyntaxException(Throwable cause) {
		super(cause);
	}

}