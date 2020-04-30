/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.jaxrs.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.liferay.portal.kernel.json.JSONArray;

import java.io.IOException;

/**
 * @author Javier Gamarra
 */
public class JSONArrayStdSerializer extends StdSerializer<JSONArray> {

	public JSONArrayStdSerializer(Class<JSONArray> clazz) {
		super(clazz);
	}

	@Override
	public void serialize(
			JSONArray jsonArray, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider)
		throws IOException {

		jsonGenerator.writeStartArray();

		for (Object object : jsonArray) {
			jsonGenerator.writeObject(object);
		}

		jsonGenerator.writeEndArray();
	}

}