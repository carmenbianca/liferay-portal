/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.key;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.cache.key.CacheKeyGenerator;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Preston Crary
 */
public class HashCodeHexStringCacheKeyGenerator extends BaseCacheKeyGenerator {

	@Override
	public CacheKeyGenerator clone() {
		return new HashCodeHexStringCacheKeyGenerator();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *			 #getCacheKey(StringBundler)}
	 */
	@Deprecated
	@Override
	public String getCacheKey(com.liferay.portal.kernel.util.StringBundler sb) {
		return getCacheKey(sb.getStrings());
	}

	@Override
	public String getCacheKey(String key) {
		return StringUtil.toHexString(key.hashCode());
	}

	@Override
	public String getCacheKey(String[] keys) {
		int hashCode = 0;
		int weight = 1;

		for (int i = keys.length - 1; i >= 0; i--) {
			String s = keys[i];

			hashCode = s.hashCode() * weight + hashCode;

			for (int j = s.length(); j > 0; j--) {
				weight *= 31;
			}
		}

		return StringUtil.toHexString(hashCode);
	}

	@Override
	public String getCacheKey(StringBundler sb) {
		return getCacheKey(sb.getStrings());
	}

}