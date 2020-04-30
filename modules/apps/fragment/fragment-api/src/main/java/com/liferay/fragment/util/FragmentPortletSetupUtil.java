/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletSetupUtil;
import com.liferay.portal.kernel.util.ArrayUtil;

import java.util.Optional;

import javax.portlet.PortletPreferences;

/**
 * @author Pavel Savinov
 */
public class FragmentPortletSetupUtil {

	public static void setPortletBareboneCSSClassName(
			PortletPreferences portletPreferences)
		throws Exception {

		JSONObject jsonObject = PortletSetupUtil.cssToJSONObject(
			portletPreferences);

		JSONObject advancedDataJSONObject = Optional.ofNullable(
			jsonObject.getJSONObject("advancedData")
		).orElse(
			JSONFactoryUtil.createJSONObject()
		);

		String customCSSClassNames = advancedDataJSONObject.getString(
			"customCSSClassName", StringPool.BLANK);

		if (ArrayUtil.contains(
				customCSSClassNames.split(StringPool.SPACE),
				"portlet-barebone")) {

			return;
		}

		advancedDataJSONObject.put(
			"customCSSClassName",
			customCSSClassNames + StringPool.SPACE + "portlet-barebone");

		jsonObject.put("advancedData", advancedDataJSONObject);

		portletPreferences.setValue("portletSetupCss", jsonObject.toString());
	}

}