/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.key;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.cache.key.CacheKeyGenerator;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public abstract class BaseCacheKeyGenerator implements CacheKeyGenerator {

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *			 #append(StringBundler)}
	 */
	@Deprecated
	@Override
	public CacheKeyGenerator append(
		com.liferay.portal.kernel.util.StringBundler sb) {

		keyBundler.append(sb.getStrings());

		return this;
	}

	@Override
	public CacheKeyGenerator append(String key) {
		keyBundler.append(key);

		return this;
	}

	@Override
	public CacheKeyGenerator append(String[] keys) {
		keyBundler.append(keys);

		return this;
	}

	@Override
	public CacheKeyGenerator append(StringBundler sb) {
		keyBundler.append(sb);

		return this;
	}

	@Override
	public abstract CacheKeyGenerator clone();

	@Override
	public Serializable finish() {
		Serializable cacheKey = getCacheKey(keyBundler);

		keyBundler.setIndex(0);

		return cacheKey;
	}

	@Override
	public boolean isCallingGetCacheKeyThreadSafe() {
		return _CALLING_GET_CACHE_KEY_THREAD_SAFE;
	}

	protected StringBundler keyBundler = new StringBundler();

	private static final boolean _CALLING_GET_CACHE_KEY_THREAD_SAFE = true;

}