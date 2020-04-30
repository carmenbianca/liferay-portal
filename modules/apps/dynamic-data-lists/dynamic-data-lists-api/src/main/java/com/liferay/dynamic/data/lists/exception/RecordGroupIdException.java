/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class RecordGroupIdException extends PortalException {

	public RecordGroupIdException() {
	}

	public RecordGroupIdException(String msg) {
		super(msg);
	}

	public RecordGroupIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RecordGroupIdException(Throwable cause) {
		super(cause);
	}

}