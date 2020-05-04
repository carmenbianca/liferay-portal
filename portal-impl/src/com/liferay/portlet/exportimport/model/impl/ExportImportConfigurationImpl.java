/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.exportimport.model.impl;

import com.liferay.portal.kernel.json.JSONFactoryUtil;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 * @author Daniel Kocsis
 */
public class ExportImportConfigurationImpl
	extends ExportImportConfigurationBaseImpl {

	@Override
	public Map<String, Serializable> getSettingsMap() {
		if (_settingsMap != null) {
			return _settingsMap;
		}

		_settingsMap = (Map<String, Serializable>)JSONFactoryUtil.deserialize(
			getSettings());

		return _settingsMap;
	}

	private Map<String, Serializable> _settingsMap;

}