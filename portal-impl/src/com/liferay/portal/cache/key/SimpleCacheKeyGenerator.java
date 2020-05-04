/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.key;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.cache.key.CacheKeyGenerator;

/**
 * @author Shuyang Zhou
 */
public class SimpleCacheKeyGenerator extends BaseCacheKeyGenerator {

	@Override
	public CacheKeyGenerator clone() {
		return new SimpleCacheKeyGenerator();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *			 #getCacheKey(StringBundler)}
	 */
	@Deprecated
	@Override
	public String getCacheKey(com.liferay.portal.kernel.util.StringBundler sb) {
		return sb.toString();
	}

	@Override
	public String getCacheKey(String key) {
		return key;
	}

	@Override
	public String getCacheKey(String[] keys) {
		StringBundler sb = new StringBundler(keys);

		return sb.toString();
	}

	@Override
	public String getCacheKey(StringBundler sb) {
		return sb.toString();
	}

}