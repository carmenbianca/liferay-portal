/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.configuration;

import com.liferay.blogs.configuration.definition.BlogsGroupServiceConfigurationOverrideImpl;
import com.liferay.portal.kernel.settings.Settings;

/**
 * @author Sergio González
 */
@Settings.OverrideClass(BlogsGroupServiceConfigurationOverrideImpl.class)
public interface BlogsGroupServiceOverriddenConfiguration
	extends BlogsGroupServiceConfiguration,
			BlogsGroupServiceConfigurationOverride {
}