/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.resources.importer.internal.portlet.preferences;

import com.liferay.exportimport.resources.importer.portlet.preferences.PortletPreferencesTranslator;
import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = "portlet.preferences.translator.portlet.id=com_liferay_journal_content_web_portlet_JournalContentPortlet",
	service = PortletPreferencesTranslator.class
)
public class JournalPortletPreferencesTranslator
	implements PortletPreferencesTranslator {

	@Override
	public void translate(
			JSONObject portletPreferencesJSONObject, String key,
			PortletPreferences portletPreferences)
		throws PortletException {

		String value = portletPreferencesJSONObject.getString(key);

		if (key.equals("articleId")) {
			String articleId = FileUtil.stripExtension(value);

			articleId = StringUtil.toUpperCase(articleId);

			value = StringUtil.replace(
				articleId, CharPool.SPACE, CharPool.DASH);
		}

		portletPreferences.setValue(key, value);
	}

}