/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.comment.web.internal.configuration.definition;

import com.liferay.comment.configuration.CommentGroupServiceConfiguration;
import com.liferay.message.boards.constants.MBConstants;
import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

import org.osgi.service.component.annotations.Component;

/**
 * @author Roberto Díaz
 * @author István András Dézsi
 */
@Component(service = ConfigurationPidMapping.class)
public class CommentGroupServiceConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return CommentGroupServiceConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return MBConstants.SERVICE_NAME;
	}

}