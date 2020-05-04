/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.document.library;

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
		"ddm.form.field.type.description=document-library-field-type-description",
		"ddm.form.field.type.display.order:Integer=8",
		"ddm.form.field.type.group=basic", "ddm.form.field.type.icon=upload",
		"ddm.form.field.type.label=document-library-field-type-label",
		"ddm.form.field.type.name=document_library",
		"ddm.form.field.type.scope=app-builder,forms"
	},
	service = DDMFormFieldType.class
)
public class DocumentLibraryDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public Class<? extends DDMFormFieldTypeSettings>
		getDDMFormFieldTypeSettings() {

		return DocumentLibraryDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getModuleName() {
		return "dynamic-data-mapping-form-field-type/DocumentLibrary" +
			"/DocumentLibrary.es";
	}

	@Override
	public String getName() {
		return "document_library";
	}

}