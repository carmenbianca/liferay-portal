/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.configuration.definition;

import com.liferay.journal.configuration.JournalGroupServiceConfiguration;
import com.liferay.journal.constants.JournalConstants;
import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

import org.osgi.service.component.annotations.Component;

/**
 * @author Juergen Kappler
 */
@Component(service = ConfigurationPidMapping.class)
public class JournalGroupServiceConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return JournalGroupServiceConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return JournalConstants.SERVICE_NAME;
	}

}