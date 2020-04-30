/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.data.provider.settings;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jonathan McCann
 */
@ProviderType
public interface DDMDataProviderSettingsProvider {

	public Class<?> getSettings();

}