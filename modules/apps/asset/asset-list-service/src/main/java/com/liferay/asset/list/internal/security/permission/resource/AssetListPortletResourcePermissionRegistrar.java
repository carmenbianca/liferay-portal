/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.internal.security.permission.resource;

import com.liferay.asset.list.constants.AssetListConstants;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.util.HashMapDictionary;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Jürgen Kappler
 */
@Component(immediate = true, service = {})
public class AssetListPortletResourcePermissionRegistrar {

	@Activate
	protected void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("resource.name", AssetListConstants.RESOURCE_NAME);

		_serviceRegistration = bundleContext.registerService(
			PortletResourcePermission.class,
			PortletResourcePermissionFactory.create(
				AssetListConstants.RESOURCE_NAME),
			properties);
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	private ServiceRegistration<PortletResourcePermission> _serviceRegistration;

}