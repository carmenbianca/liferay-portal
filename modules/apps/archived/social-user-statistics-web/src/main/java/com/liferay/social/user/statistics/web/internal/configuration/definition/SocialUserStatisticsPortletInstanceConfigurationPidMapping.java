/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.user.statistics.web.internal.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;
import com.liferay.social.user.statistics.constants.SocialUserStatisticsPortletKeys;
import com.liferay.social.user.statistics.web.internal.configuration.SocialUserStatisticsPortletInstanceConfiguration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kailash Yadav
 */
@Component(service = ConfigurationPidMapping.class)
public class SocialUserStatisticsPortletInstanceConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return SocialUserStatisticsPortletInstanceConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return SocialUserStatisticsPortletKeys.SOCIAL_USER_STATISTICS;
	}

}