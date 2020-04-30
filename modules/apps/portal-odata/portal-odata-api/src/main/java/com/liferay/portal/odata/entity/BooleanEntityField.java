/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.entity;

import java.util.Locale;
import java.util.function.Function;

/**
 * Models an date entity field. A Entity field with a type {@code
 * EntityField.Type.BOOLEAN}
 *
 * @author Cristina González
 * @review
 */
public class BooleanEntityField extends EntityField {

	/**
	 * Creates a new {@code BooleanEntityField} with a {@code Function} to
	 * convert the entity field's name to a filterable/sortable field name for a
	 * locale.
	 *
	 * @param  name the entity field's name
	 * @param  filterableAndSortableFieldNameFunction the {@code Function}
	 * @review
	 */
	public BooleanEntityField(
		String name,
		Function<Locale, String> filterableAndSortableFieldNameFunction) {

		super(
			name, Type.BOOLEAN, filterableAndSortableFieldNameFunction,
			filterableAndSortableFieldNameFunction, String::valueOf);
	}

}