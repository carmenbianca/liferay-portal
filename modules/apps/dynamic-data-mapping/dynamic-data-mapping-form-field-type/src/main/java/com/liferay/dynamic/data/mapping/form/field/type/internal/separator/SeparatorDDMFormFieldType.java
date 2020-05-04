/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.separator;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marcela Cunha
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.data.domain=separator",
		"ddm.form.field.type.description=separator-field-type-description",
		"ddm.form.field.type.display.order:Integer=11",
		"ddm.form.field.type.group=basic", "ddm.form.field.type.icon=separator",
		"ddm.form.field.type.label=separator-field-type-label",
		"ddm.form.field.type.name=separator", "ddm.form.field.type.scope=forms"
	},
	service = DDMFormFieldType.class
)
public class SeparatorDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public Class<? extends DDMFormFieldTypeSettings>
		getDDMFormFieldTypeSettings() {

		return SeparatorDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getModuleName() {
		return "dynamic-data-mapping-form-field-type/Separator/Separator.es";
	}

	@Override
	public String getName() {
		return "separator";
	}

}