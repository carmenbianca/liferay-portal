/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.key;

import com.liferay.portal.kernel.util.Digester;

/**
 * @author Shuyang Zhou
 */
public class JavaMD5CacheKeyGeneratorTest
	extends BaseCacheKeyGeneratorTestCase {

	@Override
	public void setUp() throws Exception {
		cacheKeyGenerator = new MessageDigestCacheKeyGenerator(Digester.MD5);
	}

}