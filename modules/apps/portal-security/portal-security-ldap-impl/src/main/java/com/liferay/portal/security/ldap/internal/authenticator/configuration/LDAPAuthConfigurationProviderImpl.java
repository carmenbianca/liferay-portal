/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap.internal.authenticator.configuration;

import com.liferay.portal.security.ldap.authenticator.configuration.LDAPAuthConfiguration;
import com.liferay.portal.security.ldap.configuration.CompanyScopedConfigurationProvider;
import com.liferay.portal.security.ldap.configuration.ConfigurationProvider;

import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = "factoryPid=com.liferay.portal.security.ldap.authenticator.configuration.LDAPAuthConfiguration",
	service = ConfigurationProvider.class
)
public class LDAPAuthConfigurationProviderImpl
	extends CompanyScopedConfigurationProvider<LDAPAuthConfiguration> {

	@Override
	public Class<LDAPAuthConfiguration> getMetatype() {
		return LDAPAuthConfiguration.class;
	}

	@Override
	@Reference(unbind = "-")
	protected void setConfigurationAdmin(
		ConfigurationAdmin configurationAdmin) {

		super.configurationAdmin = configurationAdmin;
	}

}