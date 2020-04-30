/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.util.service;

import com.liferay.petra.function.UnsafeFunction;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * @author Shuyang Zhou
 */
public class OSGiServiceUtil {

	public static <S, R, E extends Throwable> R callService(
			BundleContext bundleContext, Class<S> serviceClass,
			UnsafeFunction<S, R, E> unsafeFunction)
		throws E {

		ServiceReference<S> serviceReference =
			bundleContext.getServiceReference(serviceClass);

		if (serviceReference == null) {
			return unsafeFunction.apply(null);
		}

		S service = bundleContext.getService(serviceReference);

		try {
			return unsafeFunction.apply(service);
		}
		finally {
			bundleContext.ungetService(serviceReference);
		}
	}

}