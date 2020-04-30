/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Marcellus Tavares
 */
public class DDMFormEvaluationException extends PortalException {

	public DDMFormEvaluationException() {
	}

	public DDMFormEvaluationException(String msg) {
		super(msg);
	}

	public DDMFormEvaluationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DDMFormEvaluationException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}