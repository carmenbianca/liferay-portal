/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.auto.tagger.google.cloud.natural.language.internal.settings.definition;

import com.liferay.asset.auto.tagger.google.cloud.natural.language.internal.configuration.GCloudNaturalLanguageAssetAutoTaggerCompanyConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alicia García
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class
	GCloudNaturalLanguageAssetAutoTaggerCompanyConfigurationBeanDeclaration
		implements ConfigurationBeanDeclaration {

	@Override
	public Class getConfigurationBeanClass() {
		return GCloudNaturalLanguageAssetAutoTaggerCompanyConfiguration.class;
	}

}