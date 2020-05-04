/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ContentDataException extends PortalException {

	public ContentDataException() {
	}

	public ContentDataException(String msg) {
		super(msg);
	}

	public ContentDataException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ContentDataException(Throwable cause) {
		super(cause);
	}

}