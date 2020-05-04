/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.key.value;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormField;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayout;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutRow;
import com.liferay.dynamic.data.mapping.annotations.DDMFormRule;
import com.liferay.dynamic.data.mapping.form.field.type.DefaultDDMFormFieldTypeSettings;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;

/**
 * @author Bruno Basto
 */
@DDMForm(
	rules = {
		@DDMFormRule(
			actions = "setVisible('indexType', false)", condition = "TRUE"
		)
	}
)
@DDMFormLayout(
	paginationMode = com.liferay.dynamic.data.mapping.model.DDMFormLayout.SETTINGS_MODE,
	value = {
		@DDMFormLayoutPage(
			title = "%basic",
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12, value = {"label", "tip", "required"}
						)
					}
				)
			}
		),
		@DDMFormLayoutPage(
			title = "%advanced",
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12,
							value = {
								"validation", "showLabel", "repeatable",
								"placeholder", "visibilityExpression",
								"predefinedValue", "fieldNamespace",
								"indexType", "localizable", "readOnly",
								"dataType", "type", "name", "tooltip"
							}
						)
					}
				)
			}
		)
	}
)
public interface KeyValueDDMFormFieldTypeSettings
	extends DefaultDDMFormFieldTypeSettings {

	@DDMFormField(dataType = "string", label = "%field-tip", type = "text")
	public LocalizedValue placeholder();

	@DDMFormField(visibilityExpression = "FALSE")
	public LocalizedValue tooltip();

}