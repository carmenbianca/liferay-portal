/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPluginSettingException extends NoSuchModelException {

	public NoSuchPluginSettingException() {
	}

	public NoSuchPluginSettingException(String msg) {
		super(msg);
	}

	public NoSuchPluginSettingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPluginSettingException(Throwable cause) {
		super(cause);
	}

}