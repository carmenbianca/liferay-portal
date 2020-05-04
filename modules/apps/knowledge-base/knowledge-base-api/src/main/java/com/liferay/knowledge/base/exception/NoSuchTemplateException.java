/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.exception;

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