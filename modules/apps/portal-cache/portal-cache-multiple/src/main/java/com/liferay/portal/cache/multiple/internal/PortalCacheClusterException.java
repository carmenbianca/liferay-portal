/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.multiple.internal;

/**
 * @author Shuyang Zhou
 */
public class PortalCacheClusterException extends RuntimeException {

	public PortalCacheClusterException() {
	}

	public PortalCacheClusterException(String msg) {
		super(msg);
	}

	public PortalCacheClusterException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PortalCacheClusterException(Throwable cause) {
		super(cause);
	}

}