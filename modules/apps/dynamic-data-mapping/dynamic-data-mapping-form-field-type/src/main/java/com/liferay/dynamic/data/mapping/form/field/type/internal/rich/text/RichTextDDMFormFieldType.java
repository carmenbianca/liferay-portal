/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.rich.text;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Carlos Lancha
 * @author Marko Cikos
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.data.domain=text",
		"ddm.form.field.type.description=rich-text-field-type-description",
		"ddm.form.field.type.display.order:Integer=8",
		"ddm.form.field.type.group=basic", "ddm.form.field.type.icon=textbox",
		"ddm.form.field.type.label=rich-text-field-type-label",
		"ddm.form.field.type.name=rich_text", "ddm.form.field.type.scope=forms"
	},
	service = DDMFormFieldType.class
)
public class RichTextDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public Class<? extends DDMFormFieldTypeSettings>
		getDDMFormFieldTypeSettings() {

		return RichTextDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getModuleName() {
		return "dynamic-data-mapping-form-field-type/RichText/RichText.es";
	}

	@Override
	public String getName() {
		return "rich_text";
	}

}