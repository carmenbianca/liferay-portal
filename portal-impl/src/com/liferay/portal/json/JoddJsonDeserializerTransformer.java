/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json;

import com.liferay.portal.kernel.json.JSONDeserializerTransformer;

import jodd.json.ValueConverter;

/**
 * @author Preston Crary
 */
public class JoddJsonDeserializerTransformer<K, V>
	implements ValueConverter<K, V> {

	public JoddJsonDeserializerTransformer(
		JSONDeserializerTransformer<K, V> jsonDeserializerTransformer) {

		_jsonDeserializerTransformer = jsonDeserializerTransformer;
	}

	@Override
	public V convert(K key) {
		return _jsonDeserializerTransformer.transform(key);
	}

	private final JSONDeserializerTransformer<K, V>
		_jsonDeserializerTransformer;

}