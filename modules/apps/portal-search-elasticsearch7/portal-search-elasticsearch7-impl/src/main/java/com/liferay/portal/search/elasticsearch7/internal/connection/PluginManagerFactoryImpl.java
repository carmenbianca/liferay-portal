/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import java.net.URL;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;

/**
 * @author André de Oliveira
 */
public class PluginManagerFactoryImpl implements PluginManagerFactory {

	public PluginManagerFactoryImpl(Settings settings) {
		_settings = settings;
	}

	@Override
	public PluginManager createPluginManager() {
		return doCreatePluginManager(null);
	}

	@Override
	public PluginManager createPluginManager(PluginZip pluginZip) {
		return doCreatePluginManager(pluginZip.getURL());
	}

	protected PluginManager doCreatePluginManager(URL url) {
		return new PluginManagerImpl(new Environment(_settings, null), url);
	}

	private final Settings _settings;

}