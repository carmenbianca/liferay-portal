/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class TempFileNameException extends PortalException {

	public TempFileNameException() {
	}

	public TempFileNameException(String msg) {
		super(msg);
	}

	public TempFileNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TempFileNameException(Throwable cause) {
		super(cause);
	}

}