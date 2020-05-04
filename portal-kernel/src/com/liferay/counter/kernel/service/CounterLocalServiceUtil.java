/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.counter.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the local service utility for Counter. This utility wraps
 * <code>com.liferay.counter.service.impl.CounterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CounterLocalService
 * @generated
 */
public class CounterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.counter.service.impl.CounterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List<String> getNames() {
		return getService().getNames();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static long increment() {
		return getService().increment();
	}

	public static long increment(String name) {
		return getService().increment(name);
	}

	public static long increment(String name, int size) {
		return getService().increment(name, size);
	}

	public static void rename(String oldName, String newName) {
		getService().rename(oldName, newName);
	}

	public static void reset(String name) {
		getService().reset(name);
	}

	public static void reset(String name, long size) {
		getService().reset(name, size);
	}

	public static CounterLocalService getService() {
		if (_service == null) {
			_service = (CounterLocalService)PortalBeanLocatorUtil.locate(
				CounterLocalService.class.getName());
		}

		return _service;
	}

	private static CounterLocalService _service;

}