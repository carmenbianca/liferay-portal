/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.webcache;

/**
 * @author Brian Wing Shun Chan
 */
public class WebCachePoolUtil {

	public static void clear() {
		getWebCachePool().clear();
	}

	public static Object get(String key, WebCacheItem wci) {
		return getWebCachePool().get(key, wci);
	}

	public static WebCachePool getWebCachePool() {
		return _webCachePool;
	}

	public static void remove(String key) {
		getWebCachePool().remove(key);
	}

	public void setWebCachePool(WebCachePool webCachePool) {
		_webCachePool = webCachePool;
	}

	private static WebCachePool _webCachePool;

}