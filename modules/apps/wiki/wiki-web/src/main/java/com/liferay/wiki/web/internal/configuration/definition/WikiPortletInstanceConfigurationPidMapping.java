/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.web.internal.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;
import com.liferay.wiki.constants.WikiPortletKeys;
import com.liferay.wiki.web.internal.configuration.WikiPortletInstanceConfiguration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Iván Zaera
 */
@Component(service = ConfigurationPidMapping.class)
public class WikiPortletInstanceConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return WikiPortletInstanceConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return WikiPortletKeys.WIKI;
	}

}