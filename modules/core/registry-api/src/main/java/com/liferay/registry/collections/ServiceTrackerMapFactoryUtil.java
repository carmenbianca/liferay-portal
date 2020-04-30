/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.collections;

/**
 * @author Carlos Sierra Andrés
 */
public class ServiceTrackerMapFactoryUtil {

	public static ServiceTrackerMapFactory getServiceTrackerMapFactory() {
		return _serviceTrackerMapFactory;
	}

	public static void setServiceTrackerMapFactory(
		ServiceTrackerMapFactory serviceTrackerMapFactory) {

		_serviceTrackerMapFactory = serviceTrackerMapFactory;
	}

	private static ServiceTrackerMapFactory _serviceTrackerMapFactory;

}