/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache.index;

import com.liferay.petra.lang.HashUtil;

import java.io.Serializable;

/**
 * @author Preston Crary
 */
public class TestKey implements Serializable {

	public TestKey(long indexedLong, long unindexedLong) {
		_indexedLong = indexedLong;
		_unindexedLong = unindexedLong;
	}

	@Override
	public boolean equals(Object obj) {
		TestKey testKey = (TestKey)obj;

		if ((testKey._indexedLong == _indexedLong) &&
			(testKey._unindexedLong == _unindexedLong)) {

			return true;
		}

		return false;
	}

	public Long getIndexedLong() {
		return _indexedLong;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, _indexedLong);

		return HashUtil.hash(hashCode, _unindexedLong);
	}

	private final long _indexedLong;
	private final long _unindexedLong;

}