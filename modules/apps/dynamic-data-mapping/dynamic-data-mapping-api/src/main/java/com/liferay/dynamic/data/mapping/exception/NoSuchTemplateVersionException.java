/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTemplateVersionException extends NoSuchModelException {

	public NoSuchTemplateVersionException() {
	}

	public NoSuchTemplateVersionException(String msg) {
		super(msg);
	}

	public NoSuchTemplateVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTemplateVersionException(Throwable cause) {
		super(cause);
	}

}