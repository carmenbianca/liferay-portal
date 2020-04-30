/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Pavel Savinov
 */
public class LayoutClassedModelUsageActionMenuContributorRegistryUtil {

	public static LayoutClassedModelUsageActionMenuContributor
		getLayoutClassedModelUsageActionMenuContributor(String className) {

		return _layoutClassedModelUsageActionMenuContributorRegistryUtil.
			_getLayoutClassedModelUsageActionMenuContributor(className);
	}

	private LayoutClassedModelUsageActionMenuContributorRegistryUtil() {
		Bundle bundle = FrameworkUtil.getBundle(
			LayoutClassedModelUsageActionMenuContributorRegistryUtil.class);

		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundle.getBundleContext(),
			LayoutClassedModelUsageActionMenuContributor.class,
			"model.class.name");
	}

	private LayoutClassedModelUsageActionMenuContributor
		_getLayoutClassedModelUsageActionMenuContributor(String className) {

		return _serviceTrackerMap.getService(className);
	}

	private static final
		LayoutClassedModelUsageActionMenuContributorRegistryUtil
			_layoutClassedModelUsageActionMenuContributorRegistryUtil =
				new LayoutClassedModelUsageActionMenuContributorRegistryUtil();

	private final ServiceTrackerMap
		<String, LayoutClassedModelUsageActionMenuContributor>
			_serviceTrackerMap;

}