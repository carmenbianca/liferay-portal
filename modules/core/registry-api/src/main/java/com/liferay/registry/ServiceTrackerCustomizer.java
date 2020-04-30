/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry;

/**
 * @author Raymond Augé
 */
public interface ServiceTrackerCustomizer<S, T> {

	public T addingService(ServiceReference<S> serviceReference);

	public void modifiedService(
		ServiceReference<S> serviceReference, T service);

	public void removedService(ServiceReference<S> serviceReference, T service);

}