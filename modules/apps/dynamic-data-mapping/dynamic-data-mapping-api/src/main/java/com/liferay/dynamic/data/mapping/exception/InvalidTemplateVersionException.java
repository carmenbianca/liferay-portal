/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidTemplateVersionException extends PortalException {

	public InvalidTemplateVersionException() {
	}

	public InvalidTemplateVersionException(String msg) {
		super(msg);
	}

	public InvalidTemplateVersionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidTemplateVersionException(Throwable cause) {
		super(cause);
	}

}