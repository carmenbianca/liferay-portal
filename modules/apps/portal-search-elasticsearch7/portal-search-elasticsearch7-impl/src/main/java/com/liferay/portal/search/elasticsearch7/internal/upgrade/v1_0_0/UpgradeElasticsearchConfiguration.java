/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.upgrade.v1_0_0;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.elasticsearch7.configuration.ElasticsearchConfiguration;
import com.liferay.portal.search.elasticsearch7.configuration.ElasticsearchConnectionConfiguration;

import java.util.Dictionary;

import org.osgi.framework.Constants;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

/**
 * @author Bryan Engler
 */
public class UpgradeElasticsearchConfiguration extends UpgradeProcess {

	public UpgradeElasticsearchConfiguration(
		ConfigurationAdmin configurationAdmin) {

		_configurationAdmin = configurationAdmin;
	}

	@Override
	protected void doUpgrade() throws Exception {
		upgradeElasticsearchConfigurations();
	}

	protected void upgradeElasticsearchConfigurations() throws Exception {
		Configuration elasticsearchConfiguration = _getConfiguration(
			ElasticsearchConfiguration.class.getName());

		Dictionary<String, Object> elasticsearchConfigurationProperties =
			new HashMapDictionary<>();

		if (elasticsearchConfiguration != null) {
			elasticsearchConfigurationProperties =
				elasticsearchConfiguration.getProperties();
		}

		String operationMode = GetterUtil.getString(
			elasticsearchConfigurationProperties.get("operationMode"));

		if ((elasticsearchConfiguration == null) ||
			!operationMode.equals("REMOTE")) {

			_setDefaultConfigurationActivePropertyToFalse();

			return;
		}

		String remoteClusterConnectionId = GetterUtil.getString(
			elasticsearchConfigurationProperties.get(
				"remoteClusterConnectionId"));

		if (Validator.isBlank(remoteClusterConnectionId)) {
			elasticsearchConfigurationProperties.put(
				"remoteClusterConnectionId", "remote");

			elasticsearchConfiguration.update(
				elasticsearchConfigurationProperties);
		}
		else if (!remoteClusterConnectionId.equals("remote")) {
			_setDefaultConfigurationActivePropertyToFalse();
		}
	}

	private Configuration _getConfiguration(String className) throws Exception {
		String filterString = StringBundler.concat(
			"(", Constants.SERVICE_PID, "=", className, ")");

		Configuration[] configurations = _configurationAdmin.listConfigurations(
			filterString);

		if (configurations != null) {
			return configurations[0];
		}

		return null;
	}

	private Configuration _getDefaultConfiguration(String className)
		throws Exception {

		String filterString = StringBundler.concat(
			"(", Constants.SERVICE_PID, "=", className, ".*)");

		Configuration[] configurations = _configurationAdmin.listConfigurations(
			filterString);

		if (ArrayUtil.isEmpty(configurations)) {
			return null;
		}

		for (Configuration configuration : configurations) {
			Dictionary<String, Object> properties =
				configuration.getProperties();

			String fileName = GetterUtil.getString(
				properties.get("felix.fileinstall.filename"));

			if (fileName.endsWith("-default.config")) {
				return configuration;
			}
		}

		return null;
	}

	private void _setDefaultConfigurationActivePropertyToFalse()
		throws Exception {

		Configuration elasticsearchConnectionConfiguration =
			_getDefaultConfiguration(
				ElasticsearchConnectionConfiguration.class.getName());

		if (elasticsearchConnectionConfiguration == null) {
			return;
		}

		Dictionary<String, Object>
			elasticsearchConnectionConfigurationProperties =
				elasticsearchConnectionConfiguration.getProperties();

		elasticsearchConnectionConfigurationProperties.put("active", false);

		elasticsearchConnectionConfiguration.update(
			elasticsearchConnectionConfigurationProperties);
	}

	private final ConfigurationAdmin _configurationAdmin;

}