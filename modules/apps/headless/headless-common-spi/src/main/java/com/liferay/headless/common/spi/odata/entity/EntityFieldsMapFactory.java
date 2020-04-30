/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.common.spi.odata.entity;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.IdEntityField;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Javier de Arcos
 */
public class EntityFieldsMapFactory {

	public static Map<String, EntityField> create(EntityField... entityFields) {
		Stream<EntityField> stream = Arrays.stream(entityFields);

		Map<String, EntityField> entityFieldsMap = stream.collect(
			Collectors.toMap(EntityField::getName, entityField -> entityField));

		entityFieldsMap.put(
			"id",
			new IdEntityField(
				"id", locale -> Field.ENTRY_CLASS_PK, String::valueOf));

		return entityFieldsMap;
	}

}