/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.captcha;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class CaptchaException extends PortalException {

	public CaptchaException() {
	}

	public CaptchaException(String msg) {
		super(msg);
	}

	public CaptchaException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CaptchaException(Throwable cause) {
		super(cause);
	}

}