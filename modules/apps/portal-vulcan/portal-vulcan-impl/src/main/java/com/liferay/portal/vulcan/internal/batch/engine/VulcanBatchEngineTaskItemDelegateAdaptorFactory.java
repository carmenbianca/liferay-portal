/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.batch.engine;

import com.liferay.batch.engine.BatchEngineTaskItemDelegate;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.vulcan.batch.engine.VulcanBatchEngineTaskItemDelegate;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/**
 * @author Preston Crary
 */
@Component(immediate = true, service = {})
public class VulcanBatchEngineTaskItemDelegateAdaptorFactory {

	@Activate
	protected void activate(BundleContext bundleContext)
		throws InvalidSyntaxException {

		Filter filter = bundleContext.createFilter(
			"(batch.engine.task.item.delegate=true)");

		_serviceTracker = new ServiceTracker<>(
			bundleContext, filter,
			new VulcanBatchEngineTaskItemDelegateServiceTrackerCustomizer(
				bundleContext, _groupLocalService));

		_serviceTracker.open();
	}

	@Deactivate
	protected void deactivate() {
		_serviceTracker.close();
	}

	@Reference
	private GroupLocalService _groupLocalService;

	private ServiceTracker<?, ?> _serviceTracker;

	private static class
		VulcanBatchEngineTaskItemDelegateServiceTrackerCustomizer
			implements ServiceTrackerCustomizer
				<VulcanBatchEngineTaskItemDelegate, ServiceRegistration<?>> {

		@Override
		public ServiceRegistration<?> addingService(
			ServiceReference<VulcanBatchEngineTaskItemDelegate>
				serviceReference) {

			VulcanBatchEngineTaskItemDelegate<?>
				vulcanBatchEngineTaskItemDelegate = _bundleContext.getService(
					serviceReference);

			VulcanBatchEngineTaskItemDelegateAdaptor<?>
				vulcanBatchEngineTaskItemDelegateAdaptor =
					new VulcanBatchEngineTaskItemDelegateAdaptor<>(
						_groupLocalService, vulcanBatchEngineTaskItemDelegate);

			return _bundleContext.registerService(
				BatchEngineTaskItemDelegate.class,
				vulcanBatchEngineTaskItemDelegateAdaptor, null);
		}

		@Override
		public void modifiedService(
			ServiceReference<VulcanBatchEngineTaskItemDelegate>
				serviceReference,
			ServiceRegistration<?> serviceRegistration) {
		}

		@Override
		public void removedService(
			ServiceReference<VulcanBatchEngineTaskItemDelegate>
				serviceReference,
			ServiceRegistration<?> serviceRegistration) {

			serviceRegistration.unregister();

			_bundleContext.ungetService(serviceReference);
		}

		private VulcanBatchEngineTaskItemDelegateServiceTrackerCustomizer(
			BundleContext bundleContext, GroupLocalService groupLocalService) {

			_bundleContext = bundleContext;
			_groupLocalService = groupLocalService;
		}

		private final BundleContext _bundleContext;
		private final GroupLocalService _groupLocalService;

	}

}