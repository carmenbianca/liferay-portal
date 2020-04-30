/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.upgrade;

import com.liferay.portal.kernel.util.KeyValuePair;

/**
 * @author Drew Brokke
 */
public interface PrefsPropsToConfigurationUpgradeHelper {

	public void mapConfigurations(
			Class<?> configurationClass, KeyValuePair... keyValuePairs)
		throws Exception;

}