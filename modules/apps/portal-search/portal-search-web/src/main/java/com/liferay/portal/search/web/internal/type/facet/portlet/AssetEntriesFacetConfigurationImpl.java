/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.type.facet.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.facet.config.FacetConfiguration;

/**
 * @author Lino Alves
 */
public class AssetEntriesFacetConfigurationImpl
	implements AssetEntriesFacetConfiguration {

	public AssetEntriesFacetConfigurationImpl(
		FacetConfiguration facetConfiguration) {

		_jsonObject = facetConfiguration.getData();
	}

	@Override
	public int getFrequencyThreshold() {
		return _jsonObject.getInt("frequencyThreshold");
	}

	@Override
	public void setFrequencyThreshold(int frequencyThreshold) {
		_jsonObject.put("frequencyThreshold", frequencyThreshold);
	}

	protected JSONArray toJSONArray(String... values) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (String value : values) {
			jsonArray.put(value);
		}

		return jsonArray;
	}

	private final JSONObject _jsonObject;

}