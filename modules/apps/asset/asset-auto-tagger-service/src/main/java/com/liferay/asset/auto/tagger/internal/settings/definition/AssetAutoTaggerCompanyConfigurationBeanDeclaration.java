/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.auto.tagger.internal.settings.definition;

import com.liferay.asset.auto.tagger.internal.configuration.AssetAutoTaggerCompanyConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class AssetAutoTaggerCompanyConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class getConfigurationBeanClass() {
		return AssetAutoTaggerCompanyConfiguration.class;
	}

}