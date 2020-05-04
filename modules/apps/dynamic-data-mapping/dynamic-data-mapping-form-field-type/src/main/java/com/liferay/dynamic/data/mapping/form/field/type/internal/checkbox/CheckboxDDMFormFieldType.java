/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.checkbox;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Renato Rego
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.data.domain=boolean",
		"ddm.form.field.type.description=checkbox-field-type-description",
		"ddm.form.field.type.display.order:Integer=8",
		"ddm.form.field.type.group=basic",
		"ddm.form.field.type.icon=check-circle",
		"ddm.form.field.type.label=checkbox-field-type-label",
		"ddm.form.field.type.name=checkbox", "ddm.form.field.type.system=true"
	},
	service = DDMFormFieldType.class
)
public class CheckboxDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public Class<? extends DDMFormFieldTypeSettings>
		getDDMFormFieldTypeSettings() {

		return CheckboxDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getModuleName() {
		return "dynamic-data-mapping-form-field-type/Checkbox/Checkbox.es";
	}

	@Override
	public String getName() {
		return "checkbox";
	}

}