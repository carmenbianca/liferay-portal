/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.util;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/**
 * @author Adolfo Pérez
 */
public class ServiceTrackerFactory {

	public static <T> ServiceTracker<T, T> create(
		Bundle bundle, Class<T> clazz) {

		return new ServiceTracker<>(bundle.getBundleContext(), clazz, null);
	}

	public static <S, T> ServiceTracker<S, T> create(
		BundleContext bundleContext, Class<S> clazz,
		ServiceTrackerCustomizer<S, T> serviceTrackerCustomizer) {

		return new ServiceTracker<>(
			bundleContext, clazz, serviceTrackerCustomizer);
	}

	public static <S, T> ServiceTracker<S, T> create(
		BundleContext bundleContext, String filterString) {

		try {
			return new ServiceTracker<>(
				bundleContext, bundleContext.createFilter(filterString), null);
		}
		catch (InvalidSyntaxException invalidSyntaxException) {
			throwException(invalidSyntaxException);

			return null;
		}
	}

	public static <S, T> ServiceTracker<S, T> create(
		BundleContext bundleContext, String filterString,
		ServiceTrackerCustomizer<S, T> serviceTrackerCustomizer) {

		try {
			return new ServiceTracker<>(
				bundleContext, bundleContext.createFilter(filterString),
				serviceTrackerCustomizer);
		}
		catch (InvalidSyntaxException invalidSyntaxException) {
			throwException(invalidSyntaxException);

			return null;
		}
	}

	/**
	 * @deprecated As of Mueller (7.2.x), with no replacement
	 */
	@Deprecated
	public static <T> ServiceTracker<T, T> create(Class<T> clazz) {
		return create(
			FrameworkUtil.getBundle(ServiceTrackerFactory.class), clazz);
	}

	public static <T> ServiceTracker<T, T> open(Bundle bundle, Class<T> clazz) {
		ServiceTracker<T, T> serviceTracker = create(bundle, clazz);

		serviceTracker.open();

		return serviceTracker;
	}

	public static <S, T> ServiceTracker<S, T> open(
		BundleContext bundleContext, Class<S> clazz,
		ServiceTrackerCustomizer<S, T> serviceTrackerCustomizer) {

		ServiceTracker<S, T> serviceTracker = create(
			bundleContext, clazz, serviceTrackerCustomizer);

		serviceTracker.open();

		return serviceTracker;
	}

	public static <S, T> ServiceTracker<S, T> open(
		BundleContext bundleContext, String filterString) {

		ServiceTracker<S, T> serviceTracker = create(
			bundleContext, filterString);

		serviceTracker.open();

		return serviceTracker;
	}

	public static <S, T> ServiceTracker<S, T> open(
		BundleContext bundleContext, String filterString,
		ServiceTrackerCustomizer<S, T> serviceTrackerCustomizer) {

		ServiceTracker<S, T> serviceTracker = create(
			bundleContext, filterString, serviceTrackerCustomizer);

		serviceTracker.open();

		return serviceTracker;
	}

	/**
	 * @deprecated As of Mueller (7.2.x), with no replacement
	 */
	@Deprecated
	public static <T> ServiceTracker<T, T> open(Class<T> clazz) {
		ServiceTracker<T, T> serviceTracker = create(clazz);

		serviceTracker.open();

		return serviceTracker;
	}

	public static <T> T throwException(Throwable throwable) {
		return ServiceTrackerFactory.<T, RuntimeException>_throwException(
			throwable);
	}

	private static <T, E extends Throwable> T _throwException(
			Throwable throwable)
		throws E {

		throw (E)throwable;
	}

}