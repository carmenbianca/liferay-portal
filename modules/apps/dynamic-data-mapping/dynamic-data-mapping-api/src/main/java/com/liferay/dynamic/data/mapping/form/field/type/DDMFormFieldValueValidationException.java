/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Marcellus Tavares
 */
public class DDMFormFieldValueValidationException extends PortalException {

	public DDMFormFieldValueValidationException() {
	}

	public DDMFormFieldValueValidationException(String msg) {
		super(msg);
	}

	public DDMFormFieldValueValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DDMFormFieldValueValidationException(Throwable cause) {
		super(cause);
	}

}