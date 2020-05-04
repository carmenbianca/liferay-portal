/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.numeric;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Leonardo Barros
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.data.domain=number",
		"ddm.form.field.type.description=numeric-field-type-description",
		"ddm.form.field.type.display.order:Integer=7",
		"ddm.form.field.type.group=basic", "ddm.form.field.type.icon=integer",
		"ddm.form.field.type.label=numeric-field-type-label",
		"ddm.form.field.type.name=numeric",
		"ddm.form.field.type.scope=app-builder,forms"
	},
	service = DDMFormFieldType.class
)
public class NumericDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public Class<? extends DDMFormFieldTypeSettings>
		getDDMFormFieldTypeSettings() {

		return NumericDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getModuleName() {
		return "dynamic-data-mapping-form-field-type/Numeric/Numeric.es";
	}

	@Override
	public String getName() {
		return "numeric";
	}

}