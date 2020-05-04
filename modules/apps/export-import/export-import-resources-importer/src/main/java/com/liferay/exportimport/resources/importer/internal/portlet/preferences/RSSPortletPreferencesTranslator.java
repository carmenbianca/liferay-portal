/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.resources.importer.internal.portlet.preferences;

import com.liferay.exportimport.resources.importer.portlet.preferences.PortletPreferencesTranslator;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = "portlet.preferences.translator.portlet.id=com_liferay_rss_web_portlet_RSSPortlet",
	service = PortletPreferencesTranslator.class
)
public class RSSPortletPreferencesTranslator
	implements PortletPreferencesTranslator {

	@Override
	public void translate(
			JSONObject portletPreferencesJSONObject, String key,
			PortletPreferences portletPreferences)
		throws PortletException {

		if (!key.equals("titles") && !key.equals("urls")) {
			String value = portletPreferencesJSONObject.getString(key);

			portletPreferences.setValue(key, value);

			return;
		}

		List<String> valuesList = new ArrayList<>();

		JSONObject jsonObject = portletPreferencesJSONObject.getJSONObject(key);

		Iterator<String> iterator = jsonObject.keys();

		while (iterator.hasNext()) {
			String jsonObjectKey = iterator.next();

			valuesList.add(jsonObject.getString(jsonObjectKey));
		}

		String[] values = valuesList.toArray(new String[0]);

		portletPreferences.setValues(key, values);
	}

}