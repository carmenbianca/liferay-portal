/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.data.provider.internal.settings;

import com.liferay.dynamic.data.mapping.data.provider.internal.rest.DDMRESTDataProviderSettings;
import com.liferay.dynamic.data.mapping.data.provider.settings.DDMDataProviderSettingsProvider;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jonathan McCann
 */
@Component(
	immediate = true, property = "ddm.data.provider.type=rest",
	service = DDMDataProviderSettingsProvider.class
)
public class DDMRESTDataProviderSettingsProvider
	implements DDMDataProviderSettingsProvider {

	@Override
	public Class<?> getSettings() {
		return DDMRESTDataProviderSettings.class;
	}

}