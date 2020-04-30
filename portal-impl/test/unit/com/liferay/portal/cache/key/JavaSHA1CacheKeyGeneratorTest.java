/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.key;

import com.liferay.portal.kernel.util.Digester;

/**
 * @author Vilmos Papp
 */
public class JavaSHA1CacheKeyGeneratorTest
	extends BaseCacheKeyGeneratorTestCase {

	@Override
	public void setUp() throws Exception {
		cacheKeyGenerator = new MessageDigestCacheKeyGenerator(Digester.SHA_1);
	}

}