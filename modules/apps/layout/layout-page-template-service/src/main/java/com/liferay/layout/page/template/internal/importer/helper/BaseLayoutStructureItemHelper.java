/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.internal.importer.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * @author Pavel Savinov
 */
public abstract class BaseLayoutStructureItemHelper {

	protected Map<String, Object> getDefinitionMap(Object definition)
		throws Exception {

		Map<String, Object> definitionMap = null;

		if (definition instanceof Map) {
			definitionMap = (Map<String, Object>)definition;
		}
		else {
			definitionMap = _objectMapper.readValue(
				definition.toString(), Map.class);
		}

		return definitionMap;
	}

	private static final ObjectMapper _objectMapper = new ObjectMapper();

}