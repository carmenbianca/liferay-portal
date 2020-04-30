/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.user.statistics.web.internal.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import com.liferay.social.user.statistics.web.internal.configuration.SocialUserStatisticsPortletInstanceConfiguration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Iván Zaera
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class SocialUserStatisticsPortletInstanceConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return SocialUserStatisticsPortletInstanceConfiguration.class;
	}

}