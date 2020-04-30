/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.doulos.processor;

import java.util.Map;

import org.json.JSONObject;

/**
 * @author Brian Wing Shun Chan
 */
public interface DoulosRequestProcessor {

	public void destroy();

	public void process(
			String method, String pathInfo, Map<String, String[]> parameterMap,
			JSONObject payloadJSONObject, JSONObject responseJSONObject)
		throws Exception;

}