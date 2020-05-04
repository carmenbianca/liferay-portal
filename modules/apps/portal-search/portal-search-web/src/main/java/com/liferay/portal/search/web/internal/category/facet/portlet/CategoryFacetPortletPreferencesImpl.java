/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.category.facet.portlet;

import com.liferay.portal.search.web.internal.util.PortletPreferencesHelper;

import java.util.Optional;

import javax.portlet.PortletPreferences;

/**
 * @author Lino Alves
 */
public class CategoryFacetPortletPreferencesImpl
	implements CategoryFacetPortletPreferences {

	public CategoryFacetPortletPreferencesImpl(
		Optional<PortletPreferences> portletPreferencesOptional) {

		_portletPreferencesHelper = new PortletPreferencesHelper(
			portletPreferencesOptional);
	}

	@Override
	public String getDisplayStyle() {
		return _portletPreferencesHelper.getString(
			CategoryFacetPortletPreferences.PREFERENCE_KEY_DISPLAY_STYLE,
			"cloud");
	}

	@Override
	public int getFrequencyThreshold() {
		return _portletPreferencesHelper.getInteger(
			CategoryFacetPortletPreferences.PREFERENCE_KEY_FREQUENCY_THRESHOLD,
			1);
	}

	@Override
	public int getMaxTerms() {
		return _portletPreferencesHelper.getInteger(
			CategoryFacetPortletPreferences.PREFERENCE_KEY_MAX_TERMS, 10);
	}

	@Override
	public String getParameterName() {
		return _portletPreferencesHelper.getString(
			CategoryFacetPortletPreferences.PREFERENCE_KEY_PARAMETER_NAME,
			"category");
	}

	@Override
	public boolean isFrequenciesVisible() {
		return _portletPreferencesHelper.getBoolean(
			CategoryFacetPortletPreferences.PREFERENCE_KEY_FREQUENCIES_VISIBLE,
			true);
	}

	private final PortletPreferencesHelper _portletPreferencesHelper;

}