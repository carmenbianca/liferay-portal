/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.configuration;

import com.liferay.bookmarks.configuration.definition.BookmarksGroupServiceConfigurationOverrideImpl;
import com.liferay.portal.kernel.settings.Settings;

/**
 * @author Iván Zaera
 */
@Settings.OverrideClass(BookmarksGroupServiceConfigurationOverrideImpl.class)
public interface BookmarksGroupServiceOverriddenConfiguration
	extends BookmarksGroupServiceConfiguration,
			BookmarksGroupServiceConfigurationOverride {
}