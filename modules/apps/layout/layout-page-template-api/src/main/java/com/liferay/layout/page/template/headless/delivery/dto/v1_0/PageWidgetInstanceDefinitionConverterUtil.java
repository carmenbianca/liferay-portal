/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.headless.delivery.dto.v1_0;

import com.liferay.headless.delivery.dto.v1_0.PageWidgetInstanceDefinition;
import com.liferay.headless.delivery.dto.v1_0.Widget;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.PortletIdCodec;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.PortletLocalServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletPreferences;

/**
 * @author Jürgen Kappler
 */
public class PageWidgetInstanceDefinitionConverterUtil {

	public static PageWidgetInstanceDefinition toWidgetInstanceDefinition(
		long plid, String portletId) {

		if (Validator.isNull(portletId)) {
			return null;
		}

		return new PageWidgetInstanceDefinition() {
			{
				widget = new Widget() {
					{
						name = PortletIdCodec.decodePortletName(portletId);
						widgetConfig = _getWidgetConfig(plid, portletId);
					}
				};
			}
		};
	}

	private static Map<String, Object> _getWidgetConfig(
		long plid, String portletId) {

		Layout layout = LayoutLocalServiceUtil.fetchLayout(plid);

		if (layout == null) {
			return null;
		}

		String portletName = PortletIdCodec.decodePortletName(portletId);

		Portlet portlet = PortletLocalServiceUtil.getPortletById(portletName);

		if (portlet == null) {
			return null;
		}

		PortletPreferences portletPreferences =
			PortletPreferencesFactoryUtil.getLayoutPortletSetup(
				layout.getPlid(), PortletKeys.PREFS_OWNER_ID_DEFAULT,
				PortletKeys.PREFS_OWNER_TYPE_LAYOUT, plid, portletId,
				portlet.getDefaultPreferences());

		if (portletPreferences == null) {
			return null;
		}

		Map<String, Object> widgetConfigMap = new HashMap<>();

		Map<String, String[]> portletPreferencesMap =
			portletPreferences.getMap();

		for (Map.Entry<String, String[]> entrySet :
				portletPreferencesMap.entrySet()) {

			String[] values = entrySet.getValue();

			if (ArrayUtil.isNotEmpty(values)) {
				widgetConfigMap.put(entrySet.getKey(), values[0]);
			}
			else {
				widgetConfigMap.put(entrySet.getKey(), StringPool.BLANK);
			}
		}

		return widgetConfigMap;
	}

}