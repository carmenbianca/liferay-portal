/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FormInstanceNameException extends PortalException {

	public FormInstanceNameException() {
	}

	public FormInstanceNameException(String msg) {
		super(msg);
	}

	public FormInstanceNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FormInstanceNameException(Throwable cause) {
		super(cause);
	}

}