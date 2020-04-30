/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.settings.configuration;

import java.util.Dictionary;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Rachael Koestartyo
 */
@ProviderType
public interface AnalyticsConfigurationTracker {

	public AnalyticsConfiguration getAnalyticsConfiguration(long companyId);

	public AnalyticsConfiguration getAnalyticsConfiguration(String pid);

	public Dictionary<String, Object> getAnalyticsConfigurationProperties(
		long companyId);

	public Map<Long, AnalyticsConfiguration> getAnalyticsConfigurations();

	public long getCompanyId(String pid);

	public boolean isActive();

}