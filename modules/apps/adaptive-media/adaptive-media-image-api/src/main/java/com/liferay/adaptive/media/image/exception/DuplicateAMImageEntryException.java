/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateAMImageEntryException extends PortalException {

	public DuplicateAMImageEntryException() {
	}

	public DuplicateAMImageEntryException(String msg) {
		super(msg);
	}

	public DuplicateAMImageEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateAMImageEntryException(Throwable cause) {
		super(cause);
	}

}