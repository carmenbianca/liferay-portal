/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.captcha;

/**
 * @author Jonathan McCann
 */
public class CaptchaConfigurationException extends CaptchaException {

	public CaptchaConfigurationException() {
	}

	public CaptchaConfigurationException(String msg) {
		super(msg);
	}

	public CaptchaConfigurationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CaptchaConfigurationException(Throwable cause) {
		super(cause);
	}

}