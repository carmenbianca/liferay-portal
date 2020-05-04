/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.builder.internal.converter;

import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSONDeserializer;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.List;

/**
 * @author Marcellus Tavares
 */
public abstract class BaseDDMConverterTestCase {

	protected <T> T deserialize(
		String serializedDDMFormRules, Class<T> targetType) {

		JSONDeserializer<T> jsonDeserializer =
			jsonFactory.createJSONDeserializer();

		return jsonDeserializer.deserialize(serializedDDMFormRules, targetType);
	}

	protected String getBasePath() {
		return "com/liferay/dynamic/data/mapping/form/builder/internal" +
			"/converter/dependencies/";
	}

	protected String read(String fileName) throws Exception {
		Class<?> clazz = getClass();

		return StringUtil.read(
			clazz.getClassLoader(), getBasePath() + fileName);
	}

	protected <T> String serialize(List<T> rules) {
		JSONSerializer jsonSerializer = jsonFactory.createJSONSerializer();

		return jsonSerializer.serializeDeep(rules);
	}

	protected final JSONFactory jsonFactory = new JSONFactoryImpl();

}