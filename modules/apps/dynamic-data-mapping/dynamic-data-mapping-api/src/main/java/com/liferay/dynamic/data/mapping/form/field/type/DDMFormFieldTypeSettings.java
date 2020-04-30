/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormField;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayout;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutRow;

/**
 * @author Marcellus Tavares
 */
@DDMForm
@DDMFormLayout(
	{
		@DDMFormLayoutPage(
			title = "properties",
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12, value = {"dataType", "name", "type"}
						)
					}
				)
			}
		)
	}
)
public interface DDMFormFieldTypeSettings {

	@DDMFormField(
		predefinedValue = "string", required = true,
		visibilityExpression = "FALSE"
	)
	public String dataType();

	@DDMFormField(label = "%field-name", required = true)
	public String name();

	@DDMFormField(required = true, visibilityExpression = "FALSE")
	public String type();

}