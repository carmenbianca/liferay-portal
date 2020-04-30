/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.service.access.policy.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class SAPEntryNameException extends PortalException {

	public SAPEntryNameException() {
	}

	public SAPEntryNameException(String msg) {
		super(msg);
	}

	public SAPEntryNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SAPEntryNameException(Throwable cause) {
		super(cause);
	}

}