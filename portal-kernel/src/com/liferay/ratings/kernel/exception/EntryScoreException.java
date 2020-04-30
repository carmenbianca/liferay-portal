/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.ratings.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryScoreException extends PortalException {

	public EntryScoreException() {
	}

	public EntryScoreException(String msg) {
		super(msg);
	}

	public EntryScoreException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EntryScoreException(Throwable cause) {
		super(cause);
	}

}