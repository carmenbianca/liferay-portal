/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.rest.internal.odata.entity.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

/**
 * @author Drew Brokke
 */
public class AccountUserEntityModel implements EntityModel {

	public AccountUserEntityModel() {
		_entityFieldsMap = EntityModel.toEntityFieldsMap(
			new StringEntityField(
				"firstName", locale -> Field.getSortableFieldName("firstName")),
			new StringEntityField(
				"lastName", locale -> Field.getSortableFieldName("lastName")),
			new StringEntityField(
				"screenName",
				locale -> Field.getSortableFieldName("screenName")));
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	private final Map<String, EntityField> _entityFieldsMap;

}