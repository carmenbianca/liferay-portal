/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.builder.internal.servlet;

import com.liferay.dynamic.data.mapping.data.provider.DDMDataProvider;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderInputParametersSettings;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderOutputParametersSettings;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderParameterSettings;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderTracker;
import com.liferay.dynamic.data.mapping.io.DDMFormValuesDeserializer;
import com.liferay.dynamic.data.mapping.io.DDMFormValuesDeserializerDeserializeRequest;
import com.liferay.dynamic.data.mapping.io.DDMFormValuesDeserializerDeserializeResponse;
import com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceService;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.util.DDMFormFactory;
import com.liferay.dynamic.data.mapping.util.DDMFormInstanceFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ClassUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Praxedes
 */
@Component(
	immediate = true,
	property = {
		"osgi.http.whiteboard.context.path=/dynamic-data-mapping-form-builder-provider-instance-parameter-settings",
		"osgi.http.whiteboard.servlet.name=com.liferay.dynamic.data.mapping.form.builder.internal.servlet.DDMDataProviderInstanceParameterSettingsServlet",
		"osgi.http.whiteboard.servlet.pattern=/dynamic-data-mapping-form-builder-provider-instance-parameter-settings/*"
	},
	service = Servlet.class
)
public class DDMDataProviderInstanceParameterSettingsServlet
	extends BaseDDMFormBuilderServlet {

	protected JSONObject createParametersJSONObject(
			DDMDataProvider ddmDataProvider, DDMFormValues ddmFormValues)
		throws Exception {

		JSONObject parametersJSONObject = _jsonFactory.createJSONObject();

		if (!ClassUtil.isSubclass(
				ddmDataProvider.getSettings(),
				DDMDataProviderParameterSettings.class)) {

			return parametersJSONObject;
		}

		DDMDataProviderParameterSettings ddmDataProviderParameterSetting =
			(DDMDataProviderParameterSettings)DDMFormInstanceFactory.create(
				ddmDataProvider.getSettings(), ddmFormValues);

		parametersJSONObject.put(
			"inputs",
			getInputParametersJSONArray(
				ddmDataProviderParameterSetting.inputParameters())
		).put(
			"outputs",
			getOutputParametersJSONArray(
				ddmDataProviderParameterSetting.outputParameters())
		);

		return parametersJSONObject;
	}

	protected DDMFormValues deserialize(String content, DDMForm ddmForm) {
		DDMFormValuesDeserializerDeserializeRequest.Builder builder =
			DDMFormValuesDeserializerDeserializeRequest.Builder.newBuilder(
				content, ddmForm);

		DDMFormValuesDeserializerDeserializeResponse
			ddmFormValuesDeserializerDeserializeResponse =
				_jsonDDMFormValuesDeserializer.deserialize(builder.build());

		return ddmFormValuesDeserializerDeserializeResponse.getDDMFormValues();
	}

	@Override
	protected void doGet(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException, ServletException {

		JSONObject parametersJSONObject = getParameterSettingsJSONObject(
			httpServletRequest);

		if (parametersJSONObject == null) {
			httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);

			return;
		}

		httpServletResponse.setContentType(ContentTypes.APPLICATION_JSON);
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);

		ServletResponseUtil.write(
			httpServletResponse, parametersJSONObject.toJSONString());
	}

	protected DDMFormValues getDataProviderFormValues(
		DDMDataProvider ddmDataProvider,
		DDMDataProviderInstance ddmDataProviderInstance) {

		DDMForm ddmForm = DDMFormFactory.create(ddmDataProvider.getSettings());

		return deserialize(ddmDataProviderInstance.getDefinition(), ddmForm);
	}

	protected DDMDataProviderInstance getDDMDataProviderInstance(
			HttpServletRequest httpServletRequest)
		throws PortalException {

		long ddmDataProviderInstanceId = ParamUtil.getLong(
			httpServletRequest, "ddmDataProviderInstanceId");

		return _ddmDataProviderInstanceService.getDataProviderInstance(
			ddmDataProviderInstanceId);
	}

	protected JSONArray getInputParametersJSONArray(
			DDMDataProviderInputParametersSettings[]
				ddmDataProviderInputParametersSettings)
		throws Exception {

		JSONArray inputsJSONArray = _jsonFactory.createJSONArray();

		for (DDMDataProviderInputParametersSettings
				ddmDataProviderInputParameterSetting :
					ddmDataProviderInputParametersSettings) {

			String name =
				ddmDataProviderInputParameterSetting.inputParameterName();
			String type = getType(
				ddmDataProviderInputParameterSetting.inputParameterType());

			if (Validator.isNull(name) || Validator.isNull(type)) {
				continue;
			}

			String label =
				ddmDataProviderInputParameterSetting.inputParameterLabel();

			JSONObject inputJSONObject = _jsonFactory.createJSONObject();

			if (Validator.isNotNull(label)) {
				inputJSONObject.put("label", label);
			}
			else {
				inputJSONObject.put("label", name);
			}

			inputJSONObject.put(
				"name", name
			).put(
				"required",
				ddmDataProviderInputParameterSetting.inputParameterRequired()
			).put(
				"type", type
			);

			inputsJSONArray.put(inputJSONObject);
		}

		return inputsJSONArray;
	}

	protected JSONArray getOutputParametersJSONArray(
			DDMDataProviderOutputParametersSettings[]
				ddmDataProviderOutputParametersSettings)
		throws Exception {

		JSONArray outputsJSONArray = _jsonFactory.createJSONArray();

		for (DDMDataProviderOutputParametersSettings
				ddmDataProviderOutputParameterSetting :
					ddmDataProviderOutputParametersSettings) {

			String path =
				ddmDataProviderOutputParameterSetting.outputParameterPath();
			String type = getType(
				ddmDataProviderOutputParameterSetting.outputParameterType());

			if (Validator.isNull(path) || Validator.isNull(type)) {
				continue;
			}

			String name =
				ddmDataProviderOutputParameterSetting.outputParameterName();

			JSONObject outputJSONObject = _jsonFactory.createJSONObject();

			if (Validator.isNotNull(name)) {
				outputJSONObject.put("name", name);
			}
			else {
				outputJSONObject.put("name", path);
			}

			outputJSONObject.put(
				"id", ddmDataProviderOutputParameterSetting.outputParameterId()
			).put(
				"type", type
			);

			outputsJSONArray.put(outputJSONObject);
		}

		return outputsJSONArray;
	}

	protected JSONObject getParameterSettingsJSONObject(
		HttpServletRequest httpServletRequest) {

		try {
			DDMDataProviderInstance ddmDataProviderInstance =
				getDDMDataProviderInstance(httpServletRequest);

			DDMDataProvider ddmDataProvider =
				_ddmDataProviderTracker.getDDMDataProvider(
					ddmDataProviderInstance.getType());

			DDMFormValues ddmFormValues = getDataProviderFormValues(
				ddmDataProvider, ddmDataProviderInstance);

			return createParametersJSONObject(ddmDataProvider, ddmFormValues);
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		return null;
	}

	protected String getType(String type) {
		try {
			JSONArray typeJSONArray = _jsonFactory.createJSONArray(type);

			return typeJSONArray.getString(0);
		}
		catch (JSONException jsonException) {
			if (_log.isDebugEnabled()) {
				_log.debug(jsonException, jsonException);
			}

			return type;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DDMDataProviderInstanceParameterSettingsServlet.class);

	private static final long serialVersionUID = 1L;

	@Reference
	private DDMDataProviderInstanceService _ddmDataProviderInstanceService;

	@Reference
	private DDMDataProviderTracker _ddmDataProviderTracker;

	@Reference(target = "(ddm.form.values.deserializer.type=json)")
	private DDMFormValuesDeserializer _jsonDDMFormValuesDeserializer;

	@Reference
	private JSONFactory _jsonFactory;

}