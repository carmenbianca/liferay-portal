/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormField;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayout;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutRow;
import com.liferay.dynamic.data.mapping.model.DDMFormFieldValidation;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;

/**
 * @author Marcellus Tavares
 */
@DDMForm
@DDMFormLayout(
	paginationMode = com.liferay.dynamic.data.mapping.model.DDMFormLayout.TABBED_MODE,
	value = {
		@DDMFormLayoutPage(
			title = "%basic",
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12,
							value = {
								"label", "predefinedValue", "required", "tip"
							}
						)
					}
				)
			}
		),
		@DDMFormLayoutPage(
			title = "%properties",
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12,
							value = {
								"dataType", "name", "showLabel", "repeatable",
								"type", "validation", "visibilityExpression"
							}
						)
					}
				)
			}
		)
	}
)
public interface DefaultDDMFormFieldTypeSettings
	extends DDMFormFieldTypeSettings {

	@DDMFormField(visibilityExpression = "FALSE")
	public String fieldNamespace();

	@DDMFormField(
		label = "%searchable", optionLabels = {"%disable", "%keyword"},
		optionValues = {"none", "keyword"}, predefinedValue = "keyword",
		type = "radio"
	)
	public String indexType();

	@DDMFormField(
		label = "%label",
		properties = {
			"autoFocus=true", "placeholder=%enter-a-field-label",
			"tooltip=%enter-a-descriptive-field-label-that-guides-users-to-enter-the-information-you-want"
		},
		type = "text"
	)
	public LocalizedValue label();

	@DDMFormField(
		label = "%localizable", predefinedValue = "true",
		visibilityExpression = "FALSE"
	)
	public boolean localizable();

	@DDMFormField(
		label = "%predefined-value",
		properties = {
			"placeholder=%enter-a-default-value",
			"tooltip=%enter-a-default-value-that-is-submitted-if-no-other-value-is-entered"
		},
		type = "text"
	)
	public LocalizedValue predefinedValue();

	@DDMFormField(label = "%read-only", visibilityExpression = "FALSE")
	public boolean readOnly();

	@DDMFormField(label = "%repeatable", properties = "showAsSwitcher=true")
	public boolean repeatable();

	@DDMFormField(label = "%required-field", properties = "showAsSwitcher=true")
	public boolean required();

	@DDMFormField(
		label = "%show-label", predefinedValue = "true",
		properties = "showAsSwitcher=true"
	)
	public boolean showLabel();

	@DDMFormField(
		label = "%help-text",
		properties = "tooltip=%add-a-comment-to-help-users-understand-the-field-label",
		type = "text"
	)
	public LocalizedValue tip();

	@DDMFormField(
		dataType = "string", label = "%validation", type = "validation"
	)
	public DDMFormFieldValidation validation();

	@DDMFormField(
		label = "%field-visibility-expression",
		properties = {
			"placeholder=%equals(Country, \"US\")",
			"tooltip=%write-a-conditional-expression-to-control-whether-this-field-is-displayed"
		},
		visibilityExpression = "FALSE"
	)
	public String visibilityExpression();

}