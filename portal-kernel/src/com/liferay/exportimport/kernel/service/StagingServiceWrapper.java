/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StagingService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingService
 * @generated
 */
public class StagingServiceWrapper
	implements ServiceWrapper<StagingService>, StagingService {

	public StagingServiceWrapper(StagingService stagingService) {
		_stagingService = stagingService;
	}

	@Override
	public void cleanUpStagingRequest(long stagingRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_stagingService.cleanUpStagingRequest(stagingRequestId);
	}

	@Override
	public long createStagingRequest(long groupId, String checksum)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingService.createStagingRequest(groupId, checksum);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean hasRemoteLayout(
			String uuid, long groupId, boolean privateLayout)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingService.hasRemoteLayout(uuid, groupId, privateLayout);
	}

	@Override
	public void propagateExportImportLifecycleEvent(
			int code, int processFlag, String processId,
			java.util.List<java.io.Serializable> arguments)
		throws com.liferay.portal.kernel.exception.PortalException {

		_stagingService.propagateExportImportLifecycleEvent(
			code, processFlag, processId, arguments);
	}

	@Override
	public com.liferay.exportimport.kernel.lar.MissingReferences
			publishStagingRequest(
				long stagingRequestId,
				com.liferay.exportimport.kernel.model.ExportImportConfiguration
					exportImportConfiguration)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingService.publishStagingRequest(
			stagingRequestId, exportImportConfiguration);
	}

	@Override
	public void updateStagingRequest(
			long stagingRequestId, String fileName, byte[] bytes)
		throws com.liferay.portal.kernel.exception.PortalException {

		_stagingService.updateStagingRequest(stagingRequestId, fileName, bytes);
	}

	@Override
	public StagingService getWrappedService() {
		return _stagingService;
	}

	@Override
	public void setWrappedService(StagingService stagingService) {
		_stagingService = stagingService;
	}

	private StagingService _stagingService;

}