/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.user.facet.portlet;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.facet.config.FacetConfiguration;

/**
 * @author Lino Alves
 */
public class UserFacetConfigurationImpl implements UserFacetConfiguration {

	public UserFacetConfigurationImpl(FacetConfiguration facetConfiguration) {
		_jsonObject = facetConfiguration.getData();
	}

	@Override
	public int getFrequencyThreshold() {
		return _jsonObject.getInt("frequencyThreshold");
	}

	@Override
	public int getMaxTerms() {
		return _jsonObject.getInt("maxTerms");
	}

	@Override
	public void setFrequencyThreshold(int frequencyThreshold) {
		_jsonObject.put("frequencyThreshold", frequencyThreshold);
	}

	@Override
	public void setMaxTerms(int maxTerms) {
		_jsonObject.put("maxTerms", maxTerms);
	}

	private final JSONObject _jsonObject;

}