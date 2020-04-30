/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type;

import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.Value;

/**
 * @author Leonardo Barros
 */
public interface DDMFormFieldValueJSONDeserializer {

	public Value deserialize(DDMFormField ddmFormField, String serializedValue);

}