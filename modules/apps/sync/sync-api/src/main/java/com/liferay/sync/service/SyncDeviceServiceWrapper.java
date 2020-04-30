/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SyncDeviceService}.
 *
 * @author Brian Wing Shun Chan
 * @see SyncDeviceService
 * @generated
 */
public class SyncDeviceServiceWrapper
	implements ServiceWrapper<SyncDeviceService>, SyncDeviceService {

	public SyncDeviceServiceWrapper(SyncDeviceService syncDeviceService) {
		_syncDeviceService = syncDeviceService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _syncDeviceService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.sync.model.SyncDevice registerSyncDevice(
			String type, long buildNumber, int featureSet, String uuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _syncDeviceService.registerSyncDevice(
			type, buildNumber, featureSet, uuid);
	}

	@Override
	public void unregisterSyncDevice(String uuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		_syncDeviceService.unregisterSyncDevice(uuid);
	}

	@Override
	public SyncDeviceService getWrappedService() {
		return _syncDeviceService;
	}

	@Override
	public void setWrappedService(SyncDeviceService syncDeviceService) {
		_syncDeviceService = syncDeviceService;
	}

	private SyncDeviceService _syncDeviceService;

}