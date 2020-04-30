/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.ratings.kernel.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchStatsException extends NoSuchModelException {

	public NoSuchStatsException() {
	}

	public NoSuchStatsException(String msg) {
		super(msg);
	}

	public NoSuchStatsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchStatsException(Throwable cause) {
		super(cause);
	}

}