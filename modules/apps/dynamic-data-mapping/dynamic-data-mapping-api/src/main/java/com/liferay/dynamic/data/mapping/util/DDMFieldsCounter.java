/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util;

import java.util.HashMap;

/**
 * @author Eduardo Lundgren
 * @author Marcellus Tavares
 */
public class DDMFieldsCounter extends HashMap<Object, Integer> {

	@Override
	public Integer get(Object key) {
		if (!containsKey(key)) {
			put(key, 0);
		}

		return super.get(key);
	}

	public int incrementKey(Object key) {
		int value = get(key);

		put(key, ++value);

		return value;
	}

}