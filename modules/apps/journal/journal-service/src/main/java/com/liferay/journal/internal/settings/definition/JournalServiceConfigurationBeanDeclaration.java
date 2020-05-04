/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.settings.definition;

import com.liferay.journal.configuration.JournalServiceConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Juergen Kappler
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class JournalServiceConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return JournalServiceConfiguration.class;
	}

}