/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.grid;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldValueRequestParameterRetriever;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pedro Queiroz
 */
@Component(
	immediate = true, property = "ddm.form.field.type.name=grid",
	service = DDMFormFieldValueRequestParameterRetriever.class
)
public class GridDDMFormFieldValueRequestParameterRetriever
	implements DDMFormFieldValueRequestParameterRetriever {

	@Override
	public String get(
		HttpServletRequest httpServletRequest, String ddmFormFieldParameterName,
		String defaultDDMFormFieldParameterValue) {

		JSONObject jsonObject = jsonFactory.createJSONObject();

		Map<String, String[]> parameterMap =
			httpServletRequest.getParameterMap();

		if (!parameterMap.containsKey(ddmFormFieldParameterName)) {
			return jsonObject.toString();
		}

		String[] parameterValues = parameterMap.get(ddmFormFieldParameterName);

		for (String value : parameterValues) {
			if (!value.isEmpty()) {
				String[] values = value.split(";");

				jsonObject.put(values[0], values[1]);
			}
		}

		return jsonObject.toString();
	}

	@Reference
	protected JSONFactory jsonFactory;

}