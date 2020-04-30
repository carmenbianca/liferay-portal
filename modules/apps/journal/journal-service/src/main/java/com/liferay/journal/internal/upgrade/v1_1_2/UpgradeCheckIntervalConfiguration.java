/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.upgrade.v1_1_2;

import com.liferay.journal.configuration.JournalServiceConfiguration;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Time;

import java.util.Dictionary;

import org.osgi.framework.Constants;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

/**
 * @author Jonathan McCann
 */
public class UpgradeCheckIntervalConfiguration extends UpgradeProcess {

	public UpgradeCheckIntervalConfiguration(
		ConfigurationAdmin configurationAdmin) {

		_configurationAdmin = configurationAdmin;
	}

	@Override
	protected void doUpgrade() throws Exception {
		upgradeCheckIntervalConfiguration();
	}

	protected void upgradeCheckIntervalConfiguration() throws Exception {
		String filterString = StringBundler.concat(
			"(", Constants.SERVICE_PID, "=",
			JournalServiceConfiguration.class.getName(), ")");

		Configuration[] configurations = _configurationAdmin.listConfigurations(
			filterString);

		if (configurations == null) {
			return;
		}

		Configuration configuration = configurations[0];

		Dictionary<String, Object> properties = configuration.getProperties();

		if (properties == null) {
			return;
		}

		long checkIntervalMilliseconds = GetterUtil.getLong(
			properties.get("checkInterval"));

		long checkIntervalMinutes = checkIntervalMilliseconds / Time.MINUTE;

		int checkInterval = Integer.MAX_VALUE;

		if (checkIntervalMinutes <= Integer.MAX_VALUE) {
			checkInterval = (int)checkIntervalMinutes;
		}

		properties.put("checkInterval", checkInterval);

		configuration.update(properties);
	}

	private final ConfigurationAdmin _configurationAdmin;

}