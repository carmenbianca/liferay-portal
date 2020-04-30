/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.json.web.service.client.internal;

import com.liferay.petra.json.web.service.client.server.simulator.HTTPServerSimulator;
import com.liferay.petra.json.web.service.client.server.simulator.SimulatorConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * @author Igor Beslic
 */
public abstract class BaseJSONWebServiceClientTestCase {

	protected Map<String, Object> getBaseProperties() {
		Map<String, Object> properties = new HashMap<String, Object>();

		properties.put("hostName", HTTPServerSimulator.HOST_ADDRESS);
		properties.put("hostPort", HTTPServerSimulator.HOST_PORT);
		properties.put("protocol", "http");

		return properties;
	}

	protected List<NameValuePair> getParameters(String status) {
		List<NameValuePair> parameters = new ArrayList<>();

		parameters.add(
			new BasicNameValuePair(
				SimulatorConstants.HTTP_PARAMETER_RESPOND_WITH_STATUS, status));
		parameters.add(
			new BasicNameValuePair(
				SimulatorConstants.HTTP_PARAMETER_RETURN_PARMS_IN_JSON,
				"true"));

		return parameters;
	}

}