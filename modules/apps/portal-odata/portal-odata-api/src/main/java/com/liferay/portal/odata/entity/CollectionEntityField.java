/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.entity;

/**
 * Models a collection entity field.
 *
 * @author Rubén Pulido
 * @review
 */
public class CollectionEntityField extends EntityField {

	/**
	 * Creates a new {@code EntityField} of type COLLECTION.
	 *
	 * @param  entityField the entity field
	 * @review
	 */
	public CollectionEntityField(EntityField entityField) {
		super(
			entityField.getName(), Type.COLLECTION,
			locale -> entityField.getName(), locale -> entityField.getName(),
			String::valueOf);

		_entityField = entityField;
	}

	/**
	 * Gets the {@code EntityField}.
	 *
	 * @return the entity field
	 * @review
	 */
	public EntityField getEntityField() {
		return _entityField;
	}

	private final EntityField _entityField;

}