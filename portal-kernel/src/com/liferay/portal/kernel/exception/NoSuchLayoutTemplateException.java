/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLayoutTemplateException extends PortalException {

	public NoSuchLayoutTemplateException() {
	}

	public NoSuchLayoutTemplateException(String msg) {
		super(msg);
	}

	public NoSuchLayoutTemplateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLayoutTemplateException(Throwable cause) {
		super(cause);
	}

}