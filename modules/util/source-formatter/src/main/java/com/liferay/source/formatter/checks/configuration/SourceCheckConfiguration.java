/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks.configuration;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.json.JSONArrayImpl;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Hugo Huijser
 */
public class SourceCheckConfiguration {

	public SourceCheckConfiguration(String name) {
		_name = name;
	}

	public void addAttribute(String name, String value) {
		JSONArray jsonArray = _attributesJSONObject.getJSONArray(name);

		if (jsonArray == null) {
			jsonArray = new JSONArrayImpl();
		}

		for (String s : StringUtil.split(value, StringPool.COMMA)) {
			jsonArray.put(s);
		}

		_attributesJSONObject.put(name, jsonArray);
	}

	public JSONObject getAttributesJSONObject() {
		return _attributesJSONObject;
	}

	public String getName() {
		return _name;
	}

	private final JSONObject _attributesJSONObject = new JSONObjectImpl();
	private final String _name;

}