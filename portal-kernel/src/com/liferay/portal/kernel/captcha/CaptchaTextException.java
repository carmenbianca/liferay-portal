/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.captcha;

/**
 * @author Brian Wing Shun Chan
 */
public class CaptchaTextException extends CaptchaException {

	public CaptchaTextException() {
	}

	public CaptchaTextException(String msg) {
		super(msg);
	}

	public CaptchaTextException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CaptchaTextException(Throwable cause) {
		super(cause);
	}

}