/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap.internal.exportimport.configuration;

import com.liferay.portal.security.ldap.configuration.CompanyScopedConfigurationProvider;
import com.liferay.portal.security.ldap.configuration.ConfigurationProvider;
import com.liferay.portal.security.ldap.exportimport.configuration.LDAPExportConfiguration;

import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = "factoryPid=com.liferay.portal.security.ldap.exportimport.configuration.LDAPExportConfiguration",
	service = ConfigurationProvider.class
)
public class LDAPExportConfigurationProviderImpl
	extends CompanyScopedConfigurationProvider<LDAPExportConfiguration> {

	@Override
	public Class<LDAPExportConfiguration> getMetatype() {
		return LDAPExportConfiguration.class;
	}

	@Override
	@Reference(unbind = "-")
	protected void setConfigurationAdmin(
		ConfigurationAdmin configurationAdmin) {

		super.configurationAdmin = configurationAdmin;
	}

}