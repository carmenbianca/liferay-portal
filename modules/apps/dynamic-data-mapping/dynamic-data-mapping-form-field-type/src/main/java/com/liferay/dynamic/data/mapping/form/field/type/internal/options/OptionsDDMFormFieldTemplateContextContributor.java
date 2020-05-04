/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.options;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.render.DDMFormFieldRenderingContext;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marcellus Tavares
 */
@Component(
	immediate = true, property = "ddm.form.field.type.name=options",
	service = {
		DDMFormFieldTemplateContextContributor.class,
		OptionsDDMFormFieldTemplateContextContributor.class
	}
)
public class OptionsDDMFormFieldTemplateContextContributor
	implements DDMFormFieldTemplateContextContributor {

	@Override
	public Map<String, Object> getParameters(
		DDMFormField ddmFormField,
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		return HashMapBuilder.<String, Object>put(
			"allowEmptyOptions",
			GetterUtil.getBoolean(ddmFormField.getProperty("allowEmptyOptions"))
		).put(
			"defaultLanguageId",
			() -> {
				DDMForm ddmForm = ddmFormField.getDDMForm();

				return LocaleUtil.toLanguageId(ddmForm.getDefaultLocale());
			}
		).put(
			"value", getValue(ddmFormField, ddmFormFieldRenderingContext)
		).build();
	}

	protected Map<String, Object> getValue(
		DDMFormField ddmFormField,
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		OptionsDDMFormFieldContextHelper optionsDDMFormFieldContextHelper =
			new OptionsDDMFormFieldContextHelper(
				jsonFactory, ddmFormField,
				ddmFormFieldRenderingContext.getValue());

		return optionsDDMFormFieldContextHelper.getValue();
	}

	@Reference
	protected JSONFactory jsonFactory;

}