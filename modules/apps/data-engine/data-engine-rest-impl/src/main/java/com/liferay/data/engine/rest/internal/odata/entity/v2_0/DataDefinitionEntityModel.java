/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.rest.internal.odata.entity.v2_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.DateTimeEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

/**
 * @author Gabriel Albuquerque
 */
public class DataDefinitionEntityModel implements EntityModel {

	public DataDefinitionEntityModel() {
		_entityFieldsMap = EntityModel.toEntityFieldsMap(
			new DateTimeEntityField(
				"dateCreated",
				locale -> Field.getSortableFieldName(Field.CREATE_DATE),
				locale -> Field.CREATE_DATE),
			new DateTimeEntityField(
				"dateModified",
				locale -> Field.getSortableFieldName(Field.MODIFIED_DATE),
				locale -> Field.MODIFIED_DATE),
			new StringEntityField(
				"name",
				locale -> Field.getSortableFieldName(
					"localized_name_".concat(
						LocaleUtil.toLanguageId(locale)))));
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	private final Map<String, EntityField> _entityFieldsMap;

}