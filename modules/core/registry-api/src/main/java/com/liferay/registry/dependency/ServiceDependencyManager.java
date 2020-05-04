/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.dependency;

import com.liferay.registry.Filter;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceReference;
import com.liferay.registry.ServiceTracker;
import com.liferay.registry.ServiceTrackerCustomizer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael C. Han
 */
public class ServiceDependencyManager {

	public ServiceDependencyManager() {
		Registry registry = RegistryUtil.getRegistry();

		registry.registerServiceDependencyManager(this);
	}

	public void addServiceDependencyListener(
		ServiceDependencyListener serviceDependencyListener) {

		_serviceDependencyListeners.add(serviceDependencyListener);
	}

	public void destroy() {
		for (ServiceDependencyListener serviceDependencyListener :
				_serviceDependencyListeners) {

			serviceDependencyListener.destroy();
		}

		_serviceDependencyListeners.clear();

		synchronized (_serviceDependencies) {
			for (ServiceDependency serviceDependency : _serviceDependencies) {
				serviceDependency.close();
			}
		}

		_serviceDependencies.clear();

		Registry registry = RegistryUtil.getRegistry();

		registry.unregisterServiceDependencyManager(this);
	}

	public void registerDependencies(Class<?>... serviceClasses) {
		synchronized (_serviceDependencies) {
			doRegisterDependencies(serviceClasses);

			for (ServiceDependency serviceDependency : _serviceDependencies) {
				serviceDependency.open();
			}
		}
	}

	public void registerDependencies(
		Class<?>[] serviceClasses, Filter[] filters) {

		synchronized (_serviceDependencies) {
			doRegisterDependencies(serviceClasses);

			doRegisterDependencies(filters);

			for (ServiceDependency serviceDependency : _serviceDependencies) {
				serviceDependency.open();
			}
		}
	}

	public void registerDependencies(
		Collection<Class<?>> serviceClasses, Collection<Filter> filters) {

		synchronized (_serviceDependencies) {
			doRegisterDependencies(serviceClasses.toArray(new Class<?>[0]));

			doRegisterDependencies(filters.toArray(new Filter[0]));

			for (ServiceDependency serviceDependency : _serviceDependencies) {
				serviceDependency.open();
			}
		}
	}

	public void registerDependencies(Filter... filters) {
		synchronized (_serviceDependencies) {
			doRegisterDependencies(filters);

			for (ServiceDependency serviceDependency : _serviceDependencies) {
				serviceDependency.open();
			}
		}
	}

	public void removeServiceDependencyListener(
		ServiceDependencyListener serviceDependencyListener) {

		_serviceDependencyListeners.remove(serviceDependencyListener);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(3);

		sb.append("{serviceDependencies=");
		sb.append(_serviceDependencies);
		sb.append("}");

		return sb.toString();
	}

	public void verifyDependencies() {
		synchronized (_serviceDependencies) {
			for (ServiceDependency serviceDependency : _serviceDependencies) {
				if (!serviceDependency.isFulfilled()) {
					return;
				}
			}

			_serviceDependencies.notifyAll();

			for (ServiceDependencyListener serviceDependencyListener :
					_serviceDependencyListeners) {

				serviceDependencyListener.dependenciesFulfilled();
			}

			destroy();
		}
	}

	public void waitForDependencies() {
		waitForDependencies(0);
	}

	public void waitForDependencies(long timeout) {
		synchronized (_serviceDependencies) {
			if (_serviceDependencies.isEmpty()) {
				return;
			}

			boolean missingServiceDependencies = false;

			for (ServiceDependency serviceDependency : _serviceDependencies) {
				if (!serviceDependency.isFulfilled()) {
					missingServiceDependencies = true;

					break;
				}
			}

			if (missingServiceDependencies) {
				try {
					_serviceDependencies.wait(timeout);
				}
				catch (InterruptedException interruptedException) {
				}
			}
		}
	}

	protected void doRegisterDependencies(Class<?>[] serviceClasses) {
		Registry registry = RegistryUtil.getRegistry();

		for (Class<?> serviceClass : serviceClasses) {
			ServiceDependency serviceDependency = new ServiceDependency(
				serviceClass);

			_serviceDependencies.add(serviceDependency);

			ServiceTracker<Object, Object> serviceTracker =
				registry.trackServices(
					(Class<Object>)serviceClass,
					new ServiceDependencyServiceTrackerCustomizer(
						serviceDependency));

			serviceDependency.setServiceTracker(serviceTracker);
		}
	}

	protected void doRegisterDependencies(Filter[] filters) {
		Registry registry = RegistryUtil.getRegistry();

		for (Filter filter : filters) {
			ServiceDependency serviceDependency = new ServiceDependency(filter);

			_serviceDependencies.add(serviceDependency);

			ServiceTracker<Object, Object> serviceTracker =
				registry.trackServices(
					filter,
					new ServiceDependencyServiceTrackerCustomizer(
						serviceDependency));

			serviceDependency.setServiceTracker(serviceTracker);
		}
	}

	private final Set<ServiceDependency> _serviceDependencies = new HashSet<>();
	private final Set<ServiceDependencyListener> _serviceDependencyListeners =
		new HashSet<>();

	private class ServiceDependencyServiceTrackerCustomizer
		implements ServiceTrackerCustomizer<Object, Object> {

		public ServiceDependencyServiceTrackerCustomizer(
			ServiceDependency serviceDependency) {

			_serviceDependency = serviceDependency;
		}

		@Override
		public Object addingService(ServiceReference<Object> serviceReference) {
			synchronized (_serviceDependencies) {
				Registry registry = RegistryUtil.getRegistry();

				Object service = registry.getService(serviceReference);

				_serviceDependency.fulfilled(serviceReference);

				verifyDependencies();

				return service;
			}
		}

		@Override
		public void modifiedService(
			ServiceReference<Object> serviceReference, Object service) {
		}

		@Override
		public void removedService(
			ServiceReference<Object> serviceReference, Object service) {
		}

		private final ServiceDependency _serviceDependency;

	}

}