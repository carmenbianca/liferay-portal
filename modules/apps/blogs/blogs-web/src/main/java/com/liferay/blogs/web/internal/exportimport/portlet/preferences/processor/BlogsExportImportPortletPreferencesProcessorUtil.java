/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.exportimport.portlet.preferences.processor;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.portlet.PortletPreferences;

/**
 * @author Máté Thurzó
 */
public class BlogsExportImportPortletPreferencesProcessorUtil {

	public static String getDisplayStyle(
		PortletPreferences portletPreferences) {

		try {
			TemplateHandler templateHandler =
				TemplateHandlerRegistryUtil.getTemplateHandler(
					BlogsEntry.class.getName());

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
					BlogsEntry.class.getName());

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