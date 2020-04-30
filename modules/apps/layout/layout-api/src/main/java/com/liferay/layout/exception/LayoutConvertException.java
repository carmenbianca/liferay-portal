/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutConvertException extends PortalException {

	public LayoutConvertException() {
	}

	public LayoutConvertException(String msg) {
		super(msg);
	}

	public LayoutConvertException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LayoutConvertException(Throwable cause) {
		super(cause);
	}

}