/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.document.library.thumbnails.internal.settings.definition;

import com.liferay.adaptive.media.document.library.thumbnails.internal.configuration.AMSystemImagesConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author István András Dézsi
 * @author Roberto Díaz
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class AMSystemImagesConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return AMSystemImagesConfiguration.class;
	}

}