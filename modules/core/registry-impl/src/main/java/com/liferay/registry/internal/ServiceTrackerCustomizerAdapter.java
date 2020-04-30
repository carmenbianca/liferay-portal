/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.internal;

import com.liferay.registry.ServiceTrackerCustomizer;

import org.osgi.framework.ServiceReference;

/**
 * @author Raymond Augé
 */
public class ServiceTrackerCustomizerAdapter<S, T>
	implements org.osgi.util.tracker.ServiceTrackerCustomizer<S, T> {

	public ServiceTrackerCustomizerAdapter(
		ServiceTrackerCustomizer<S, T> serviceTrackerCustomizer) {

		_serviceTrackerCustomizer = serviceTrackerCustomizer;
	}

	@Override
	public T addingService(ServiceReference<S> serviceReference) {
		return _serviceTrackerCustomizer.addingService(
			new ServiceReferenceWrapper<S>(serviceReference));
	}

	@Override
	public void modifiedService(
		ServiceReference<S> serviceReference, T service) {

		_serviceTrackerCustomizer.modifiedService(
			new ServiceReferenceWrapper<S>(serviceReference), service);
	}

	@Override
	public void removedService(
		ServiceReference<S> serviceReference, T service) {

		_serviceTrackerCustomizer.removedService(
			new ServiceReferenceWrapper<S>(serviceReference), service);
	}

	private final ServiceTrackerCustomizer<S, T> _serviceTrackerCustomizer;

}