/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.modified.facet.portlet;

import com.liferay.portal.kernel.json.JSONArray;

/**
 * @author Lino Alves
 */
public interface ModifiedFacetPortletPreferences {

	public static final String PREFERENCE_KEY_FREQUENCIES_VISIBLE =
		"frequenciesVisible";

	public static final String PREFERENCE_KEY_PARAMETER_NAME = "parameterName";

	public static final String PREFERENCE_KEY_RANGES = "ranges";

	public String getParameterName();

	public JSONArray getRangesJSONArray();

	public String getRangesString();

}