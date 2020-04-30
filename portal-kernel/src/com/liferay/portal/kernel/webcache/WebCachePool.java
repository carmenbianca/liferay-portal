/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.webcache;

/**
 * @author Brian Wing Shun Chan
 */
public interface WebCachePool {

	public void clear();

	public Object get(String key, WebCacheItem wci);

	public void remove(String key);

}