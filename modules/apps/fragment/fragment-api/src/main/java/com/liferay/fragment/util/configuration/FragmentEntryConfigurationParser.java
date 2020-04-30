/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.util.configuration;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jürgen Kappler
 */
@ProviderType
public interface FragmentEntryConfigurationParser {

	public JSONObject getConfigurationDefaultValuesJSONObject(
		String configuration);

	public JSONObject getConfigurationJSONObject(
			String configuration, String editableValues,
			long[] segmentsExperienceIds)
		throws JSONException;

	public Map<String, Object> getContextObjects(
		JSONObject configurationValuesJSONObject, String configuration);

	public Map<String, Object> getContextObjects(
		JSONObject configurationValuesJSONObject, String configuration,
		long[] segmentsExperienceIds);

	public Object getFieldValue(
		FragmentConfigurationField fragmentConfigurationField, String value);

	public Object getFieldValue(
		String configuration, String editableValues,
		long[] segmentsExperienceIds, String name);

	public List<FragmentConfigurationField> getFragmentConfigurationFields(
		String configuration);

	public JSONObject getSegmentedConfigurationValues(
		long[] segmentsExperienceIds, JSONObject configurationValuesJSONObject);

	public boolean isPersonalizationSupported(JSONObject jsonObject);

	public String translateConfiguration(
		JSONObject jsonObject, ResourceBundle resourceBundle);

}