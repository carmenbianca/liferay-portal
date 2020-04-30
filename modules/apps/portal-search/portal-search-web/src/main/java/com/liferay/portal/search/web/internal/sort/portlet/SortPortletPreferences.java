/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.sort.portlet;

import com.liferay.portal.kernel.json.JSONArray;

/**
 * @author Wade Cao
 */
public interface SortPortletPreferences {

	public static final String PREFERENCE_KEY_FIELDS = "fields";

	public JSONArray getFieldsJSONArray();

	public String getFieldsString();

	public String getParameterName();

}