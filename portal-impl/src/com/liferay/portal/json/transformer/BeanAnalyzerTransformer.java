/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json.transformer;

import com.liferay.portal.kernel.util.LinkedHashMapBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jodd.introspector.PropertyDescriptor;

import jodd.json.JsonSerializer;
import jodd.json.TypeJsonVisitor;

/**
 * @author Igor Spasic
 */
public class BeanAnalyzerTransformer extends TypeJsonVisitor {

	public BeanAnalyzerTransformer(Class<?> clazz) {
		super(_jsonSerializer.createJsonContext(null), clazz);
	}

	public List<Map<String, String>> collect() {
		_propertiesList = new ArrayList<>();

		visit();

		return _propertiesList;
	}

	protected String getTypeName(Class<?> clazz) {
		return clazz.getName();
	}

	@Override
	protected void onSerializableProperty(
		String propertyName, PropertyDescriptor propertyDescriptor) {

		Map<String, String> properties = LinkedHashMapBuilder.put(
			"name", propertyName
		).put(
			"type", getTypeName(propertyDescriptor.getType())
		).build();

		_propertiesList.add(properties);
	}

	private static final JsonSerializer _jsonSerializer = new JsonSerializer();

	private List<Map<String, String>> _propertiesList = new ArrayList<>();

}