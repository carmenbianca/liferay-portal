/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

import com.liferay.petra.string.StringPool;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iván Zaera
 */
public class FallbackKeys {

	public void add(String key, String... fallbackKeysArray) {
		if (_fallbackKeysMap.containsKey(key)) {
			throw new IllegalArgumentException("Duplicate key " + key);
		}

		_fallbackKeysMap.put(key, fallbackKeysArray);
	}

	public String[] get(String key) {
		String[] fallbackKeysArray = _fallbackKeysMap.get(key);

		if (fallbackKeysArray == null) {
			return StringPool.EMPTY_ARRAY;
		}

		return fallbackKeysArray;
	}

	private final Map<String, String[]> _fallbackKeysMap = new HashMap<>();

}