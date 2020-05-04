/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.scope.internal.liferay;

import com.liferay.oauth2.provider.scope.internal.configuration.ScopeLocatorConfiguration;
import com.liferay.oauth2.provider.scope.internal.liferay.ScopeLocatorImpl.ScopeLocatorConfigurationProvider;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

/**
 * @author Stian Sigvartsen
 */
@Component(
	configurationPid = "com.liferay.oauth2.provider.scope.internal.configuration.ScopeLocatorConfiguration",
	configurationPolicy = ConfigurationPolicy.REQUIRE, immediate = true,
	service = ScopeLocatorConfigurationProvider.class
)
public class ScopeLocatorConfigurationProviderImpl
	implements ScopeLocatorConfigurationProvider {

	public ScopeLocatorConfiguration getScopeLocatorConfiguration() {
		return _scopeLocatorConfiguration;
	}

	@Activate
	protected void activate(Map<String, Object> properties) {
		_scopeLocatorConfiguration = ConfigurableUtil.createConfigurable(
			ScopeLocatorConfiguration.class, properties);
	}

	private ScopeLocatorConfiguration _scopeLocatorConfiguration;

}