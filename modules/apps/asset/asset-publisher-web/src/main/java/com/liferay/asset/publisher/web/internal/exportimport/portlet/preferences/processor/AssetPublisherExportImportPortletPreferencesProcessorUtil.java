/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.web.internal.exportimport.portlet.preferences.processor;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.portlet.PortletPreferences;

/**
 * Provides utility methods used for the Asset Publisher's export and import
 * capabilities.
 *
 * @author Máté Thurzó
 */
public class AssetPublisherExportImportPortletPreferencesProcessorUtil {

	public static String getDisplayStyle(
		PortletPreferences portletPreferences) {

		try {
			TemplateHandler templateHandler =
				TemplateHandlerRegistryUtil.getTemplateHandler(
					AssetEntry.class.getName());

			if (templateHandler != null) {
				return portletPreferences.getValue("displayStyle", null);
			}
		}
		catch (Exception exception) {
		}

		return null;
	}

	public static long getDisplayStyleGroupId(
		PortletPreferences portletPreferences) {

		try {
			TemplateHandler templateHandler =
				TemplateHandlerRegistryUtil.getTemplateHandler(
					AssetEntry.class.getName());

			if (templateHandler != null) {
				return GetterUtil.getLong(
					portletPreferences.getValue("displayStyleGroupId", null));
			}
		}
		catch (Exception exception) {
		}

		return 0;
	}

}