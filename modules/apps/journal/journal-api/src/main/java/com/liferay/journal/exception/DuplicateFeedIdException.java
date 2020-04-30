/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DuplicateFeedIdException extends PortalException {

	public DuplicateFeedIdException() {
	}

	public DuplicateFeedIdException(String msg) {
		super(msg);
	}

	public DuplicateFeedIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateFeedIdException(Throwable cause) {
		super(cause);
	}

}