/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.sanitizer;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Zsolt Balogh
 * @author Brian Wing Shun Chan
 */
public class SanitizerException extends PortalException {

	public SanitizerException() {
	}

	public SanitizerException(String msg) {
		super(msg);
	}

	public SanitizerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SanitizerException(Throwable cause) {
		super(cause);
	}

}