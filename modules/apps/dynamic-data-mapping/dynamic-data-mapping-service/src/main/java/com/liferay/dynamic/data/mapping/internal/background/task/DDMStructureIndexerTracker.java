/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.background.task;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerCustomizerFactory;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerCustomizerFactory.ServiceWrapper;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.DDMStructureIndexer;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Igor Fabiano Nazar
 * @author Lucas Marques de Paula
 */
@Component(immediate = true, service = DDMStructureIndexerTracker.class)
public class DDMStructureIndexerTracker {

	public DDMStructureIndexer getDDMStructureIndexer(String className)
		throws PortalException {

		ServiceWrapper<DDMStructureIndexer> serviceWrapper =
			_serviceTrackerMap.getService(className);

		if (serviceWrapper == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"No dynamic data mapping structure indexer exists for " +
						className);
			}

			return null;
		}

		return serviceWrapper.getService();
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, DDMStructureIndexer.class,
			"ddm.structure.indexer.class.name",
			ServiceTrackerCustomizerFactory.<DDMStructureIndexer>serviceWrapper(
				bundleContext));
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerMap.close();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DDMStructureIndexerTracker.class);

	private ServiceTrackerMap<String, ServiceWrapper<DDMStructureIndexer>>
		_serviceTrackerMap;

}