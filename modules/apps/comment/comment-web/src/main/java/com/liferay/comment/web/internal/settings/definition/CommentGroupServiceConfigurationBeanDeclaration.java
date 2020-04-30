/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.comment.web.internal.settings.definition;

import com.liferay.comment.configuration.CommentGroupServiceConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Roberto Díaz
 * @author István András Dézsi
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class CommentGroupServiceConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return CommentGroupServiceConfiguration.class;
	}

}