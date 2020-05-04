/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.messaging.internal;

import com.liferay.petra.executor.PortalExecutorManager;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactory;
import com.liferay.portal.kernel.service.UserLocalService;

/**
 * @author Michael C. Han
 */
public class ParallelDestinationPrototype implements DestinationPrototype {

	public ParallelDestinationPrototype(
		PortalExecutorManager portalExecutorManager,
		PermissionCheckerFactory permissionCheckerFactory,
		UserLocalService userLocalService) {

		_portalExecutorManager = portalExecutorManager;
		_permissionCheckerFactory = permissionCheckerFactory;
		_userLocalService = userLocalService;
	}

	@Override
	public Destination createDestination(
		DestinationConfiguration destinationConfiguration) {

		ParallelDestination parallelDestination = new ParallelDestination();

		parallelDestination.setDestinationType(
			destinationConfiguration.getDestinationType());
		parallelDestination.setName(
			destinationConfiguration.getDestinationName());
		parallelDestination.setMaximumQueueSize(
			destinationConfiguration.getMaximumQueueSize());
		parallelDestination.setPermissionCheckerFactory(
			_permissionCheckerFactory);
		parallelDestination.setPortalExecutorManager(_portalExecutorManager);
		parallelDestination.setRejectedExecutionHandler(
			destinationConfiguration.getRejectedExecutionHandler());
		parallelDestination.setUserLocalService(_userLocalService);
		parallelDestination.setWorkersCoreSize(
			destinationConfiguration.getWorkersCoreSize());
		parallelDestination.setWorkersMaxSize(
			destinationConfiguration.getWorkersMaxSize());

		parallelDestination.afterPropertiesSet();

		return parallelDestination;
	}

	private final PermissionCheckerFactory _permissionCheckerFactory;
	private final PortalExecutorManager _portalExecutorManager;
	private final UserLocalService _userLocalService;

}