/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.category.facet.portlet;

/**
 * @author Lino Alves
 */
public interface CategoryFacetPortletPreferences {

	public static final String PREFERENCE_KEY_DISPLAY_STYLE =
		"categoryFacetDisplayStyle";

	public static final String PREFERENCE_KEY_FREQUENCIES_VISIBLE =
		"frequenciesVisible";

	public static final String PREFERENCE_KEY_FREQUENCY_THRESHOLD =
		"frequencyThreshold";

	public static final String PREFERENCE_KEY_MAX_TERMS = "maxTerms";

	public static final String PREFERENCE_KEY_PARAMETER_NAME = "parameterName";

	public String getDisplayStyle();

	public int getFrequencyThreshold();

	public int getMaxTerms();

	public String getParameterName();

	public boolean isFrequenciesVisible();

}