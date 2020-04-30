/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchRegionException extends NoSuchModelException {

	public NoSuchRegionException() {
	}

	public NoSuchRegionException(String msg) {
		super(msg);
	}

	public NoSuchRegionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRegionException(Throwable cause) {
		super(cause);
	}

}