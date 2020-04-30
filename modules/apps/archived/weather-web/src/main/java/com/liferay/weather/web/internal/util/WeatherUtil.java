/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.weather.web.internal.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;
import com.liferay.weather.web.internal.model.Weather;

/**
 * @author Brian Wing Shun Chan
 */
public class WeatherUtil {

	public static Weather getWeather(String zip, String apiKey) {
		String key = WeatherUtil.class.getName() + StringPool.PERIOD + zip;

		WebCacheItem wci = new WeatherWebCacheItem(zip, apiKey);

		try {
			return (Weather)WebCachePoolUtil.get(key, wci);
		}
		catch (ClassCastException classCastException) {
			WebCachePoolUtil.remove(key);

			return (Weather)WebCachePoolUtil.get(key, wci);
		}
	}

}