/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FormInstanceNotPublishedException extends PortalException {

	public FormInstanceNotPublishedException() {
	}

	public FormInstanceNotPublishedException(String msg) {
		super(msg);
	}

	public FormInstanceNotPublishedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FormInstanceNotPublishedException(Throwable cause) {
		super(cause);
	}

}