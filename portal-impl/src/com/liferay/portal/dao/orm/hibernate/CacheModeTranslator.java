/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.portal.kernel.dao.orm.CacheMode;

/**
 * @author Brian Wing Shun Chan
 */
public class CacheModeTranslator {

	public static org.hibernate.CacheMode translate(CacheMode cacheMode) {
		if (cacheMode == CacheMode.GET) {
			return org.hibernate.CacheMode.GET;
		}
		else if (cacheMode == CacheMode.IGNORE) {
			return org.hibernate.CacheMode.IGNORE;
		}
		else if (cacheMode == CacheMode.NORMAL) {
			return org.hibernate.CacheMode.NORMAL;
		}
		else if (cacheMode == CacheMode.PUT) {
			return org.hibernate.CacheMode.PUT;
		}
		else if (cacheMode == CacheMode.REFRESH) {
			return org.hibernate.CacheMode.REFRESH;
		}

		return org.hibernate.CacheMode.parse(cacheMode.getName());
	}

}