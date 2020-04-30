/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Thrown when the system identifies a violation of the Record Set Name required
 * property.
 *
 * @author Brian Wing Shun Chan
 */
public class RecordSetNameException extends PortalException {

	public RecordSetNameException() {
	}

	public RecordSetNameException(String msg) {
		super(msg);
	}

	public RecordSetNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RecordSetNameException(Throwable cause) {
		super(cause);
	}

}