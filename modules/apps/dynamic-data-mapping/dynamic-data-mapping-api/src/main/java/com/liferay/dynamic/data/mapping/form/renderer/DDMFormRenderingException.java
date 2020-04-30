/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.renderer;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Marcellus Tavares
 */
public class DDMFormRenderingException extends PortalException {

	public DDMFormRenderingException() {
	}

	public DDMFormRenderingException(String msg) {
		super(msg);
	}

	public DDMFormRenderingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DDMFormRenderingException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}