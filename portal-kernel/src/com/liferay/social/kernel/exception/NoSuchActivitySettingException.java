/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchActivitySettingException extends NoSuchModelException {

	public NoSuchActivitySettingException() {
	}

	public NoSuchActivitySettingException(String msg) {
		super(msg);
	}

	public NoSuchActivitySettingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchActivitySettingException(Throwable cause) {
		super(cause);
	}

}