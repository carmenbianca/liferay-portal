/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.module.framework.service;

import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceReference;
import com.liferay.registry.ServiceTracker;
import com.liferay.registry.ServiceTrackerCustomizer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tina Tian
 */
public class IdentifiableOSGiServiceUtil {

	public static IdentifiableOSGiService getIdentifiableOSGiService(
		String osgiServiceIdentifier) {

		return _identifiableOSGiServices.get(osgiServiceIdentifier);
	}

	private IdentifiableOSGiServiceUtil() {
	}

	private static final Map<String, IdentifiableOSGiService>
		_identifiableOSGiServices = new ConcurrentHashMap<>();
	private static final ServiceTracker
		<IdentifiableOSGiService, IdentifiableOSGiService> _serviceTracker;

	private static class IdentifiableOSGiServiceServiceTrackerCustomizer
		implements ServiceTrackerCustomizer
			<IdentifiableOSGiService, IdentifiableOSGiService> {

		@Override
		public IdentifiableOSGiService addingService(
			ServiceReference<IdentifiableOSGiService> serviceReference) {

			Registry registry = RegistryUtil.getRegistry();

			IdentifiableOSGiService identifiableOSGiService =
				registry.getService(serviceReference);

			_identifiableOSGiServices.put(
				identifiableOSGiService.getOSGiServiceIdentifier(),
				identifiableOSGiService);

			return identifiableOSGiService;
		}

		@Override
		public void modifiedService(
			ServiceReference<IdentifiableOSGiService> serviceReference,
			IdentifiableOSGiService identifiableOSGiService) {

			_identifiableOSGiServices.put(
				identifiableOSGiService.getOSGiServiceIdentifier(),
				identifiableOSGiService);
		}

		@Override
		public void removedService(
			ServiceReference<IdentifiableOSGiService> serviceReference,
			IdentifiableOSGiService identifiableOSGiService) {

			Registry registry = RegistryUtil.getRegistry();

			registry.ungetService(serviceReference);

			_identifiableOSGiServices.remove(
				identifiableOSGiService.getOSGiServiceIdentifier());
		}

	}

	static {
		Registry registry = RegistryUtil.getRegistry();

		_serviceTracker = registry.trackServices(
			IdentifiableOSGiService.class,
			new IdentifiableOSGiServiceServiceTrackerCustomizer());

		_serviceTracker.open();
	}

}