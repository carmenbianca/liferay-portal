/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.internal.configuration.definition;

import com.liferay.bookmarks.configuration.BookmarksGroupServiceConfiguration;
import com.liferay.bookmarks.constants.BookmarksConstants;
import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

import org.osgi.service.component.annotations.Component;

/**
 * @author Iván Zaera
 */
@Component(service = ConfigurationPidMapping.class)
public class BookmarksGroupServiceConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return BookmarksGroupServiceConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return BookmarksConstants.SERVICE_NAME;
	}

}