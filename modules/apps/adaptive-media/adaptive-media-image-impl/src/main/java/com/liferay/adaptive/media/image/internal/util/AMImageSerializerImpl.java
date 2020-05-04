/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.internal.util;

import com.liferay.adaptive.media.AMAttribute;
import com.liferay.adaptive.media.AdaptiveMedia;
import com.liferay.adaptive.media.exception.AMRuntimeException;
import com.liferay.adaptive.media.image.internal.configuration.AMImageAttributeMapping;
import com.liferay.adaptive.media.image.internal.processor.AMImage;
import com.liferay.adaptive.media.image.processor.AMImageAttribute;
import com.liferay.adaptive.media.image.processor.AMImageProcessor;
import com.liferay.adaptive.media.image.util.AMImageSerializer;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;

import java.io.InputStream;

import java.net.URI;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(immediate = true, service = AMImageSerializer.class)
public class AMImageSerializerImpl implements AMImageSerializer {

	@Override
	public AdaptiveMedia<AMImageProcessor> deserialize(
		String s, Supplier<InputStream> inputStreamSupplier) {

		try {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(s);

			Map<String, String> properties = new HashMap<>();

			JSONObject attributesJSONObject = jsonObject.getJSONObject(
				"attributes");

			Map<String, AMAttribute<?, ?>> allowedAMAttributes =
				AMImageAttribute.getAllowedAMAttributes();

			allowedAMAttributes.forEach(
				(name, amAttribute) -> {
					if (attributesJSONObject.has(name)) {
						properties.put(
							name, attributesJSONObject.getString(name));
					}
				});

			String uri = jsonObject.getString("uri");

			return new AMImage(
				inputStreamSupplier,
				AMImageAttributeMapping.fromProperties(properties),
				URI.create(uri));
		}
		catch (JSONException jsonException) {
			throw new AMRuntimeException(jsonException);
		}
	}

	@Override
	public String serialize(AdaptiveMedia<AMImageProcessor> adaptiveMedia) {
		JSONObject attributesJSONObject = JSONFactoryUtil.createJSONObject();

		Map<String, AMAttribute<?, ?>> allowedAMAttributes =
			AMImageAttribute.getAllowedAMAttributes();

		allowedAMAttributes.forEach(
			(name, amAttribute) -> {
				Optional<Object> valueOptional = adaptiveMedia.getValueOptional(
					(AMAttribute)amAttribute);

				valueOptional.ifPresent(
					value -> attributesJSONObject.put(
						name, String.valueOf(value)));
			});

		JSONObject jsonObject = JSONUtil.put(
			"attributes", attributesJSONObject
		).put(
			"uri", adaptiveMedia.getURI()
		);

		return jsonObject.toString();
	}

}