/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTemplateException extends NoSuchModelException {

	public NoSuchTemplateException() {
	}

	public NoSuchTemplateException(String msg) {
		super(msg);
	}

	public NoSuchTemplateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTemplateException(Throwable cause) {
		super(cause);
	}

}