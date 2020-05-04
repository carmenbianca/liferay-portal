/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.settings;

import org.apache.commons.lang.StringUtils;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.SettingsException;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author André de Oliveira
 */
public class SettingsBuilder {

	public SettingsBuilder(Settings.Builder builder) {
		_builder = builder;
	}

	public Settings build() {
		return _builder.build();
	}

	public Settings.Builder getBuilder() {
		return _builder;
	}

	public void loadFromSource(String source) {
		if (StringUtils.isBlank(source)) {
			return;
		}

		try {
			_builder.loadFromSource(source, XContentType.JSON);
		}
		catch (SettingsException settingsException) {
			_builder.loadFromSource(source, XContentType.YAML);
		}
	}

	public void put(String key, boolean value) {
		_builder.put(key, value);
	}

	public void put(String key, String value) {
		if (!StringUtils.isBlank(value)) {
			_builder.put(key, value);
		}
	}

	public void putList(String setting, String... values) {
		_builder.putList(setting, values);
	}

	private final Settings.Builder _builder;

}