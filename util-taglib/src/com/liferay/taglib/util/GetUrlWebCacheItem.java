/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.util;

import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.webcache.WebCacheException;
import com.liferay.portal.kernel.webcache.WebCacheItem;

/**
 * @author Brian Wing Shun Chan
 */
public class GetUrlWebCacheItem implements WebCacheItem {

	public GetUrlWebCacheItem(String url, long refreshTime) {
		_url = url;
		_refreshTime = refreshTime;
	}

	@Override
	public Object convert(String key) throws WebCacheException {
		String url = _url;

		String content = null;

		try {
			content = HttpUtil.URLtoString(_url);
		}
		catch (Exception exception) {
			throw new WebCacheException(url + " " + exception.toString());
		}

		return content;
	}

	@Override
	public long getRefreshTime() {
		return _refreshTime;
	}

	private final long _refreshTime;
	private final String _url;

}