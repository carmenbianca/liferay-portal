/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.key;

/**
 * @author Shuyang Zhou
 */
public class SimpleCacheKeyGeneratorTest extends BaseCacheKeyGeneratorTestCase {

	@Override
	public void setUp() throws Exception {
		cacheKeyGenerator = new SimpleCacheKeyGenerator();
	}

}