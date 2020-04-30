/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.asset.auto.tagger.microsoft.cognitive.services.internal.settings.definition;

import com.liferay.document.library.asset.auto.tagger.microsoft.cognitive.services.internal.configuration.MSCognitiveServicesAssetAutoTagProviderCompanyConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class
	MSCognitiveServicesAssetAutoTagProviderCompanyConfigurationBeanDeclaration
		implements ConfigurationBeanDeclaration {

	@Override
	public Class getConfigurationBeanClass() {
		return MSCognitiveServicesAssetAutoTagProviderCompanyConfiguration.
			class;
	}

}