/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.template;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Tina Tian
 */
public class TemplateException extends PortalException {

	public TemplateException() {
	}

	public TemplateException(String msg) {
		super(msg);
	}

	public TemplateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TemplateException(Throwable cause) {
		super(cause);
	}

}