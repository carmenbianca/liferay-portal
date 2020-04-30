/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.multiple.internal;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.cache.PortalCacheManager;

import java.io.Serializable;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Tina Tian
 */
@Component(enabled = false, immediate = true, service = {})
public class PortalCacheManagerUtil {

	public static PortalCacheManager<? extends Serializable, ?>
		getPortalCacheManager(String portalCacheManagerName) {

		ServiceTrackerMap<String, PortalCacheManager<? extends Serializable, ?>>
			serviceTrackerMap = _serviceTrackerMap;

		PortalCacheManager<? extends Serializable, ?> portalCacheManager = null;

		if (serviceTrackerMap != null) {
			portalCacheManager = serviceTrackerMap.getService(
				portalCacheManagerName);
		}

		if (portalCacheManager != null) {
			return portalCacheManager;
		}

		throw new IllegalStateException(
			"Unable to get portal cache manager " + portalCacheManagerName);
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext,
			(Class<PortalCacheManager<? extends Serializable, ?>>)
				(Class<?>)PortalCacheManager.class,
			null,
			(serviceReference, emitter) -> {
				PortalCacheManager<? extends Serializable, ?>
					portalCacheManager = bundleContext.getService(
						serviceReference);

				emitter.emit(portalCacheManager.getPortalCacheManagerName());
			});
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerMap.close();
	}

	private static volatile ServiceTrackerMap
		<String, PortalCacheManager<? extends Serializable, ?>>
			_serviceTrackerMap;

}