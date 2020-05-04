/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceReference;
import com.liferay.registry.ServiceRegistration;
import com.liferay.registry.collections.ServiceReferenceMapper;
import com.liferay.registry.collections.ServiceRegistrationMap;
import com.liferay.registry.collections.ServiceRegistrationMapImpl;
import com.liferay.registry.collections.ServiceTrackerCollections;
import com.liferay.registry.collections.ServiceTrackerMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Eduardo García
 * @author Raymond Augé
 */
public class FriendlyURLResolverRegistryUtil {

	public static FriendlyURLResolver getFriendlyURLResolver(
		String urlSeparator) {

		return _serviceTrackerMap.getService(urlSeparator);
	}

	public static Collection<FriendlyURLResolver>
		getFriendlyURLResolversAsCollection() {

		List<FriendlyURLResolver> friendlyURLResolvers = new ArrayList<>();

		for (String key : _serviceTrackerMap.keySet()) {
			FriendlyURLResolver friendlyURLResolver =
				_serviceTrackerMap.getService(key);

			if (friendlyURLResolver != null) {
				friendlyURLResolvers.add(friendlyURLResolver);
			}
		}

		return friendlyURLResolvers;
	}

	public static String[] getURLSeparators() {
		Set<String> urlSeparators = _serviceTrackerMap.keySet();

		return urlSeparators.toArray(new String[0]);
	}

	public static void register(FriendlyURLResolver friendlyURLResolver) {
		Registry registry = RegistryUtil.getRegistry();

		ServiceRegistration<FriendlyURLResolver> serviceRegistration =
			registry.registerService(
				FriendlyURLResolver.class, friendlyURLResolver);

		_serviceRegistrations.put(friendlyURLResolver, serviceRegistration);
	}

	public static void unregister(FriendlyURLResolver friendlyURLResolver) {
		ServiceRegistration<FriendlyURLResolver> serviceRegistration =
			_serviceRegistrations.remove(friendlyURLResolver);

		if (serviceRegistration != null) {
			serviceRegistration.unregister();
		}
	}

	private static final ServiceRegistrationMap<FriendlyURLResolver>
		_serviceRegistrations = new ServiceRegistrationMapImpl<>();

	private static final ServiceTrackerMap<String, FriendlyURLResolver>
		_serviceTrackerMap = ServiceTrackerCollections.openSingleValueMap(
			FriendlyURLResolver.class, null,
			new ServiceReferenceMapper<String, FriendlyURLResolver>() {

				@Override
				public void map(
					ServiceReference<FriendlyURLResolver> serviceReference,
					ServiceReferenceMapper.Emitter<String> emitter) {

					Registry registry = RegistryUtil.getRegistry();

					FriendlyURLResolver friendlyURLResolver =
						registry.getService(serviceReference);

					emitter.emit(friendlyURLResolver.getURLSeparator());

					registry.ungetService(serviceReference);
				}

			});

}