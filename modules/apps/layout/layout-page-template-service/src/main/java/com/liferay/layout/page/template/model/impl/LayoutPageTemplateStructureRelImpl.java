/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.model.impl;

import com.liferay.layout.page.template.util.LayoutDataConverter;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Eudaldo Alonso
 */
public class LayoutPageTemplateStructureRelImpl
	extends LayoutPageTemplateStructureRelBaseImpl {

	@Override
	public String getData() {
		String data = super.getData();

		try {
			JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject(data);

			if (LayoutDataConverter.isLatestVersion(dataJSONObject)) {
				return data;
			}

			return LayoutDataConverter.convert(data);
		}
		catch (JSONException jsonException) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to parse JSON object", jsonException);
			}
		}

		return data;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LayoutPageTemplateStructureRelImpl.class);

}