/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.util;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author     Pavel Savinov
 * @deprecated As of Athanasius (7.3.x), replaced by {@link
 *             com.liferay.layout.util.LayoutClassedModelUsageActionMenuContributorRegistryUtil}
 */
@Deprecated
public class AssetEntryUsageActionMenuContributorRegistryUtil {

	public static AssetEntryUsageActionMenuContributor
		getAssetEntryUsageActionMenuContributor(String className) {

		return _assetEntryUsageActionMenuContributorRegistryUtil.
			_getAssetEntryUsageActionMenuContributor(className);
	}

	private AssetEntryUsageActionMenuContributorRegistryUtil() {
		Bundle bundle = FrameworkUtil.getBundle(
			AssetEntryUsageActionMenuContributorRegistryUtil.class);

		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundle.getBundleContext(),
			AssetEntryUsageActionMenuContributor.class, "model.class.name");
	}

	private AssetEntryUsageActionMenuContributor
		_getAssetEntryUsageActionMenuContributor(String className) {

		return _serviceTrackerMap.getService(className);
	}

	private static final AssetEntryUsageActionMenuContributorRegistryUtil
		_assetEntryUsageActionMenuContributorRegistryUtil =
			new AssetEntryUsageActionMenuContributorRegistryUtil();

	private final ServiceTrackerMap
		<String, AssetEntryUsageActionMenuContributor> _serviceTrackerMap;

}