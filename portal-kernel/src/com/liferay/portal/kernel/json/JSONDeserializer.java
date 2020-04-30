/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.json;

/**
 * @author Brian Wing Shun Chan
 */
public interface JSONDeserializer<T> {

	public T deserialize(String input);

	public T deserialize(String input, Class<T> targetType);

	public <K, V> JSONDeserializer<T> transform(
		JSONDeserializerTransformer<K, V> jsonDeserializerTransformer,
		String field);

	public JSONDeserializer<T> use(String path, Class<?> clazz);

}