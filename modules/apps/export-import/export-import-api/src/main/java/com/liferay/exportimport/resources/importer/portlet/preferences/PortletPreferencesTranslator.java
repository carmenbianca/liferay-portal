/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.resources.importer.portlet.preferences;

import com.liferay.portal.kernel.json.JSONObject;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

/**
 * @author Michael C. Han
 */
public interface PortletPreferencesTranslator {

	public void translate(
			JSONObject portletPreferencesJSONObject, String key,
			PortletPreferences portletPreferences)
		throws PortletException;

}