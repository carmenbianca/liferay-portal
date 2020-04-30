/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.validation;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.render.DDMFormFieldRenderingContext;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bruno Basto
 */
@Component(
	immediate = true, property = "ddm.form.field.type.name=validation",
	service = {
		DDMFormFieldTemplateContextContributor.class,
		ValidationDDMFormFieldTemplateContextContributor.class
	}
)
public class ValidationDDMFormFieldTemplateContextContributor
	implements DDMFormFieldTemplateContextContributor {

	@Override
	public Map<String, Object> getParameters(
		DDMFormField ddmFormField,
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		return HashMapBuilder.<String, Object>put(
			"value", getValue(ddmFormFieldRenderingContext)
		).build();
	}

	protected Map<String, Object> getValue(
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		String valueString = ddmFormFieldRenderingContext.getValue();

		if (Validator.isNotNull(valueString)) {
			try {
				JSONObject valueJSONObject = jsonFactory.createJSONObject(
					valueString);

				return HashMapBuilder.<String, Object>put(
					"errorMessage",
					valueJSONObject.getJSONObject("errorMessage")
				).put(
					"expression", valueJSONObject.getJSONObject("expression")
				).put(
					"parameter", valueJSONObject.getJSONObject("parameter")
				).build();
			}
			catch (JSONException jsonException) {
				if (_log.isWarnEnabled()) {
					_log.warn(jsonException, jsonException);
				}
			}
		}

		return HashMapBuilder.<String, Object>put(
			"errorMessage", jsonFactory.createJSONObject()
		).put(
			"expression", jsonFactory.createJSONObject()
		).put(
			"parameter", jsonFactory.createJSONObject()
		).build();
	}

	@Reference
	protected JSONFactory jsonFactory;

	private static final Log _log = LogFactoryUtil.getLog(
		ValidationDDMFormFieldTemplateContextContributor.class);

}