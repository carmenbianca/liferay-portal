/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap.internal.configuration;

import com.liferay.portal.security.ldap.configuration.CompanyScopedConfigurationProvider;
import com.liferay.portal.security.ldap.configuration.ConfigurationProvider;
import com.liferay.portal.security.ldap.configuration.SystemLDAPConfiguration;

import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = "factoryPid=com.liferay.portal.security.ldap.configuration.SystemLDAPConfiguration",
	service = ConfigurationProvider.class
)
public class SystemLDAPConfigurationProviderImpl
	extends CompanyScopedConfigurationProvider<SystemLDAPConfiguration> {

	@Override
	public Class<SystemLDAPConfiguration> getMetatype() {
		return SystemLDAPConfiguration.class;
	}

	@Override
	@Reference(unbind = "-")
	protected void setConfigurationAdmin(
		ConfigurationAdmin configurationAdmin) {

		super.configurationAdmin = configurationAdmin;
	}

}