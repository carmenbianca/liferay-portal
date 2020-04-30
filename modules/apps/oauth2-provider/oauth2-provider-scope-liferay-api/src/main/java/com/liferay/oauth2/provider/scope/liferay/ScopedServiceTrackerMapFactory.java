/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.scope.liferay;

import java.util.function.Supplier;

import org.osgi.framework.BundleContext;

/**
 * @author Carlos Sierra Andrés
 */
public interface ScopedServiceTrackerMapFactory {

	public default <T> ScopedServiceTrackerMap<T> create(
		BundleContext bundleContext, Class<T> clazz, String property,
		Supplier<T> defaultServiceSupplier) {

		return create(
			bundleContext, clazz, property, defaultServiceSupplier,
			() -> {
			});
	}

	public <T> ScopedServiceTrackerMap<T> create(
		BundleContext bundleContext, Class<T> clazz, String property,
		Supplier<T> defaultServiceSupplier, Runnable onChangeRunnable);

}