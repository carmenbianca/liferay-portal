/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author     Eduardo García
 * @deprecated As of Judson (7.1.x), replaced by {@link
 *             com.liferay.trash.exception.TrashEntryException}
 */
@Deprecated
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