/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache.index;

/**
 * @author Preston Crary
 */
public class TestKeyIndexEncoder implements IndexEncoder<Long, TestKey> {

	@Override
	public Long encode(TestKey testKey) {
		return testKey.getIndexedLong();
	}

}