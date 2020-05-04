/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.service.access.policy.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateSAPEntryNameException extends PortalException {

	public DuplicateSAPEntryNameException() {
	}

	public DuplicateSAPEntryNameException(String msg) {
		super(msg);
	}

	public DuplicateSAPEntryNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateSAPEntryNameException(Throwable cause) {
		super(cause);
	}

}