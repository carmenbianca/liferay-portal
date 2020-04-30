/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.chat.internal.settings.definition;

import com.liferay.chat.internal.configuration.ChatGroupServiceConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Peter Fellwock
 */
@Component(enabled = false, service = ConfigurationBeanDeclaration.class)
public class ChatGroupServiceConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return ChatGroupServiceConfiguration.class;
	}

}