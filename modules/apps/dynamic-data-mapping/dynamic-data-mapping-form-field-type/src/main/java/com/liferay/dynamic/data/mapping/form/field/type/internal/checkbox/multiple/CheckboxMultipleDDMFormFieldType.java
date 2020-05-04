/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.checkbox.multiple;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Dylan Rebelak
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.data.domain=list",
		"ddm.form.field.type.description=checkbox-multiple-field-type-description",
		"ddm.form.field.type.display.order:Integer=4",
		"ddm.form.field.type.group=basic",
		"ddm.form.field.type.icon=check-circle-full",
		"ddm.form.field.type.label=checkbox-multiple-field-type-label",
		"ddm.form.field.type.name=checkbox_multiple",
		"ddm.form.field.type.scope=app-builder,forms"
	},
	service = DDMFormFieldType.class
)
public class CheckboxMultipleDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public Class<? extends DDMFormFieldTypeSettings>
		getDDMFormFieldTypeSettings() {

		return CheckboxMultipleDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getModuleName() {
		return "dynamic-data-mapping-form-field-type/CheckboxMultiple" +
			"/CheckboxMultiple.es";
	}

	@Override
	public String getName() {
		return "checkbox_multiple";
	}

}