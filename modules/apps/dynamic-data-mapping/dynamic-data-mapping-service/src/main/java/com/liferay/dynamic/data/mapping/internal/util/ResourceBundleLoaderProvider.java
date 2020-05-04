/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.util;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Jürgen Kappler
 */
@Component(service = ResourceBundleLoaderProvider.class)
public class ResourceBundleLoaderProvider {

	public ResourceBundleLoader getResourceBundleLoader(
		String bundleSymbolicName) {

		ResourceBundleLoader resourceBundleLoader =
			_resourceBundleLoaders.getService(bundleSymbolicName);

		if (resourceBundleLoader == null) {
			return ResourceBundleLoaderUtil.getPortalResourceBundleLoader();
		}

		return new AggregateResourceBundleLoader(
			resourceBundleLoader,
			ResourceBundleLoaderUtil.getPortalResourceBundleLoader());
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_resourceBundleLoaders = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, ResourceBundleLoader.class, "bundle.symbolic.name");
	}

	@Deactivate
	protected void deactivate() {
		_resourceBundleLoaders.close();
	}

	private ServiceTrackerMap<String, ResourceBundleLoader>
		_resourceBundleLoaders;

}