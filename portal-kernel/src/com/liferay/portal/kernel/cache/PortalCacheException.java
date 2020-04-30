/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache;

/**
 * @author Joseph Shum
 */
public class PortalCacheException extends RuntimeException {

	public PortalCacheException() {
	}

	public PortalCacheException(String msg) {
		super(msg);
	}

	public PortalCacheException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PortalCacheException(Throwable cause) {
		super(cause);
	}

}