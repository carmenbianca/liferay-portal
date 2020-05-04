/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.profile;

import java.util.HashSet;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

/**
 * @author Shuyang Zhou
 */
public class BaseDSModulePortalProfile implements PortalProfile {

	@Override
	public void activate() {
		for (String componentName : _componentNames) {
			_componentContext.enableComponent(componentName);
		}
	}

	@Override
	public Set<String> getPortalProfileNames() {
		return _supportedPortalProfileNames;
	}

	protected void init(
		ComponentContext componentContext,
		Set<String> supportedPortalProfileNames, String... componentNames) {

		_componentContext = componentContext;

		_supportedPortalProfileNames = new HashSet<>(
			supportedPortalProfileNames);

		BundleContext bundleContext = componentContext.getBundleContext();

		Bundle bundle = bundleContext.getBundle();

		_supportedPortalProfileNames.add(bundle.getSymbolicName());

		_componentNames = componentNames;
	}

	private ComponentContext _componentContext;
	private String[] _componentNames;
	private Set<String> _supportedPortalProfileNames;

}