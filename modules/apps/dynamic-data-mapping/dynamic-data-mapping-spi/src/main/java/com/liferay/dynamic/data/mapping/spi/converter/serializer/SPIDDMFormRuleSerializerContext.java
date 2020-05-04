/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.spi.converter.serializer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Rafael Praxedes
 */
public class SPIDDMFormRuleSerializerContext {

	public void addAttribute(String key, Object value) {
		_serializerContext.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T getAttribute(String key) {
		return (T)_serializerContext.get(key);
	}

	private final Map<String, Object> _serializerContext =
		new ConcurrentHashMap<>();

}