/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class TrashEntryException extends PortalException {

	public TrashEntryException() {
	}

	public TrashEntryException(String msg) {
		super(msg);
	}

	public TrashEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TrashEntryException(Throwable cause) {
		super(cause);
	}

}