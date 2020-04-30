/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class LRUMap<K, V> extends LinkedHashMap<K, V> {

	public LRUMap(int capacity) {
		super(capacity * 3 / 2, 0.75F, true);

		_capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		if (size() > _capacity) {
			return true;
		}

		return false;
	}

	private final int _capacity;

}