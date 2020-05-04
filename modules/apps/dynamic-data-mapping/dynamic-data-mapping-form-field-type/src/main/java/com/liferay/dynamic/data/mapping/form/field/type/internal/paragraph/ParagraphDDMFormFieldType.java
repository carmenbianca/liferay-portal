/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.paragraph;

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
		"ddm.form.field.type.description=paragraph-field-type-description",
		"ddm.form.field.type.display.order:Integer=1",
		"ddm.form.field.type.group=interface",
		"ddm.form.field.type.icon=paragraph",
		"ddm.form.field.type.label=paragraph-field-type-label",
		"ddm.form.field.type.name=paragraph", "ddm.form.field.type.scope=forms"
	},
	service = DDMFormFieldType.class
)
public class ParagraphDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public Class<? extends DDMFormFieldTypeSettings>
		getDDMFormFieldTypeSettings() {

		return ParagraphDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getModuleName() {
		return "dynamic-data-mapping-form-field-type/Paragraph/Paragraph.es";
	}

	@Override
	public String getName() {
		return "paragraph";
	}

}