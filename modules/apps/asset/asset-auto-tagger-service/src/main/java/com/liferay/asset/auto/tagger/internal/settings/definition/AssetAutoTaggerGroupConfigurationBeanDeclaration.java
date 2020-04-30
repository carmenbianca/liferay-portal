/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.auto.tagger.internal.settings.definition;

import com.liferay.asset.auto.tagger.internal.configuration.AssetAutoTaggerGroupConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class AssetAutoTaggerGroupConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class getConfigurationBeanClass() {
		return AssetAutoTaggerGroupConfiguration.class;
	}

}