/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.data.provider.instance;

import com.liferay.dynamic.data.mapping.data.provider.DDMDataProvider;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderOutputParametersSettings;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderParameterSettings;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderRequest;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderResponse;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.KeyValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Praxedes
 */
@Component(
	immediate = true,
	property = "ddm.data.provider.instance.id=getDataProviderInstanceOutputParameters",
	service = DDMDataProvider.class
)
public class DDMDataProviderInstanceOutputParametersDataProvider
	implements DDMDataProvider {

	@Override
	public DDMDataProviderResponse getData(
		DDMDataProviderRequest ddmDataProviderRequest) {

		Optional<Long> dataProviderInstanceIdOptional =
			ddmDataProviderRequest.getParameterOptional(
				"dataProviderInstanceId", String.class);

		long dataProviderInstanceId = 0;

		if (dataProviderInstanceIdOptional.isPresent()) {
			dataProviderInstanceId = GetterUtil.getLong(
				dataProviderInstanceIdOptional.get());
		}

		DDMDataProviderResponse.Builder builder =
			DDMDataProviderResponse.Builder.newBuilder();

		List<KeyValuePair> keyValuePairs = new ArrayList<>();

		if (dataProviderInstanceId == 0) {
			return builder.withOutput(
				"outputParameterNames", keyValuePairs
			).build();
		}

		try {
			DDMDataProviderOutputParametersSettings[]
				ddmDataProviderOutputParametersSettings =
					getDDMDataProviderOutputParametersSettings(
						dataProviderInstanceId);

			for (DDMDataProviderOutputParametersSettings
					ddmDataProviderOutputParametersSetting :
						ddmDataProviderOutputParametersSettings) {

				keyValuePairs.add(
					new KeyValuePair(
						ddmDataProviderOutputParametersSetting.
							outputParameterId(),
						ddmDataProviderOutputParametersSetting.
							outputParameterName()));
			}
		}
		catch (Exception exception) {
			_log.error(
				String.format(
					"Unable to get the output parameters for data provider " +
						"instance with id '%d'",
					dataProviderInstanceId),
				exception);
		}

		return builder.withOutput(
			"outputParameterNames", keyValuePairs
		).build();
	}

	@Override
	public Class<?> getSettings() {
		throw new UnsupportedOperationException();
	}

	protected DDMFormValues deserialize(String content, DDMForm ddmForm) {
		DDMFormValuesDeserializerDeserializeRequest.Builder builder =
			DDMFormValuesDeserializerDeserializeRequest.Builder.newBuilder(
				content, ddmForm);

		DDMFormValuesDeserializerDeserializeResponse
			ddmFormValuesDeserializerDeserializeResponse =
				jsonDDMFormValuesDeserializer.deserialize(builder.build());

		return ddmFormValuesDeserializerDeserializeResponse.getDDMFormValues();
	}

	protected DDMFormValues getDataProviderInstanceFormValues(
		DDMDataProvider ddmDataProvider,
		DDMDataProviderInstance ddmDataProviderInstance) {

		DDMForm ddmForm = DDMFormFactory.create(ddmDataProvider.getSettings());

		return deserialize(ddmDataProviderInstance.getDefinition(), ddmForm);
	}

	protected DDMDataProviderOutputParametersSettings[]
			getDDMDataProviderOutputParametersSettings(
				long dataProviderInstanceId)
		throws Exception {

		DDMDataProviderInstance ddmDataProviderInstance =
			ddmDataProviderInstanceService.getDataProviderInstance(
				dataProviderInstanceId);

		DDMDataProvider ddmDataProvider =
			ddmDataProviderTracker.getDDMDataProvider(
				ddmDataProviderInstance.getType());

		if (!ClassUtil.isSubclass(
				ddmDataProvider.getSettings(),
				DDMDataProviderParameterSettings.class)) {

			return new DDMDataProviderOutputParametersSettings[0];
		}

		DDMFormValues dataProviderFormValues =
			getDataProviderInstanceFormValues(
				ddmDataProvider, ddmDataProviderInstance);

		DDMDataProviderParameterSettings ddmDataProviderParameterSetting =
			DDMFormInstanceFactory.create(
				DDMDataProviderParameterSettings.class, dataProviderFormValues);

		return ddmDataProviderParameterSetting.outputParameters();
	}

	@Reference
	protected DDMDataProviderInstanceService ddmDataProviderInstanceService;

	@Reference
	protected DDMDataProviderTracker ddmDataProviderTracker;

	@Reference(target = "(ddm.form.values.deserializer.type=json)")
	protected DDMFormValuesDeserializer jsonDDMFormValuesDeserializer;

	private static final Log _log = LogFactoryUtil.getLog(
		DDMDataProviderInstanceOutputParametersDataProvider.class);

}