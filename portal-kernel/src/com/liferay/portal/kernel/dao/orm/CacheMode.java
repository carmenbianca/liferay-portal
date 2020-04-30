/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

/**
 * @author Brian Wing Shun Chan
 */
public interface CacheMode {

	public static final CacheMode GET = new CacheModeImpl("GET");

	public static final CacheMode IGNORE = new CacheModeImpl("IGNORE");

	public static final CacheMode NORMAL = new CacheModeImpl("NORMAL");

	public static final CacheMode PUT = new CacheModeImpl("PUT");

	public static final CacheMode REFRESH = new CacheModeImpl("REFRESH");

	public String getName();

}