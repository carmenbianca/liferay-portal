/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.runtime;

import java.util.Optional;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * @author Igor Beslic
 */
public class LiferayRequestContentAggregatorSink extends LiferaySink {

	@Override
	public Optional<JsonObject> doPatchRequest(
		String resourceURL, JsonObject jsonObject) {

		return _processRequest(resourceURL, jsonObject);
	}

	@Override
	public Optional<JsonObject> doPostRequest(
		String resourceURL, JsonObject jsonObject) {

		return _processRequest(resourceURL, jsonObject);
	}

	public JsonObject getOutputJsonObject() {
		return _outputJsonObject;
	}

	public String getOutputResourceURL() {
		return _outputResourceURL;
	}

	private Optional<JsonObject> _processRequest(
		String resourceURL, JsonObject jsonObject) {

		_outputResourceURL = resourceURL;
		_outputJsonObject = jsonObject;

		JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder(
			jsonObject);

		jsonObjectBuilder.add("success", "true");

		return Optional.of(jsonObjectBuilder.build());
	}

	private JsonObject _outputJsonObject;
	private String _outputResourceURL;

}