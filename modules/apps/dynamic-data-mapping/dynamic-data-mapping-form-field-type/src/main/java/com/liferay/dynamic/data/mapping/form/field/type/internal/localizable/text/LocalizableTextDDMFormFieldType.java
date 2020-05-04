/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.localizable.text;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bruno Basto
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.description=localizable-text-field-type-description",
		"ddm.form.field.type.display.order:Integer=1",
		"ddm.form.field.type.group=basic", "ddm.form.field.type.icon=text",
		"ddm.form.field.type.label=localizable-text-field-type-label",
		"ddm.form.field.type.name=localizable_text",
		"ddm.form.field.type.system=true"
	},
	service = DDMFormFieldType.class
)
public class LocalizableTextDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public Class<? extends DDMFormFieldTypeSettings>
		getDDMFormFieldTypeSettings() {

		return LocalizableTextDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getModuleName() {
		return "dynamic-data-mapping-form-field-type/LocalizableText" +
			"/LocalizableText.es";
	}

	@Override
	public String getName() {
		return "localizable_text";
	}

}