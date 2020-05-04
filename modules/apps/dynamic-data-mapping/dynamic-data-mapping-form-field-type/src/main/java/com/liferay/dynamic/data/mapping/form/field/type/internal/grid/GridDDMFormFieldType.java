/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.grid;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pedro Queiroz
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.data.domain=list",
		"ddm.form.field.type.description=grid-field-type-description",
		"ddm.form.field.type.display.order:Integer=5",
		"ddm.form.field.type.group=basic", "ddm.form.field.type.icon=table2",
		"ddm.form.field.type.label=grid-field-type-label",
		"ddm.form.field.type.name=grid", "ddm.form.field.type.scope=forms"
	},
	service = DDMFormFieldType.class
)
public class GridDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public Class<? extends DDMFormFieldTypeSettings>
		getDDMFormFieldTypeSettings() {

		return GridDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getModuleName() {
		return "dynamic-data-mapping-form-field-type/Grid/Grid.es";
	}

	@Override
	public String getName() {
		return "grid";
	}

}