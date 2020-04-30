/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.service.base.ThemeServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ThemeServiceImpl extends ThemeServiceBaseImpl {

	@Override
	public List<Theme> getThemes(long companyId) {
		return themeLocalService.getThemes(companyId);
	}

	@Override
	public JSONArray getWARThemes() {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		List<Theme> themes = themeLocalService.getWARThemes();

		for (Theme theme : themes) {
			JSONObject jsonObject = JSONUtil.put(
				"servlet_context_name", theme.getServletContextName()
			).put(
				"theme_id", theme.getThemeId()
			).put(
				"theme_name", theme.getName()
			);

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

}