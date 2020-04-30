/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for Staging. This utility wraps
 * <code>com.liferay.portlet.exportimport.service.impl.StagingServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see StagingService
 * @generated
 */
public class StagingServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portlet.exportimport.service.impl.StagingServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void cleanUpStagingRequest(long stagingRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().cleanUpStagingRequest(stagingRequestId);
	}

	public static long createStagingRequest(long groupId, String checksum)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createStagingRequest(groupId, checksum);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static boolean hasRemoteLayout(
			String uuid, long groupId, boolean privateLayout)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().hasRemoteLayout(uuid, groupId, privateLayout);
	}

	public static void propagateExportImportLifecycleEvent(
			int code, int processFlag, String processId,
			java.util.List<java.io.Serializable> arguments)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().propagateExportImportLifecycleEvent(
			code, processFlag, processId, arguments);
	}

	public static com.liferay.exportimport.kernel.lar.MissingReferences
			publishStagingRequest(
				long stagingRequestId,
				com.liferay.exportimport.kernel.model.ExportImportConfiguration
					exportImportConfiguration)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().publishStagingRequest(
			stagingRequestId, exportImportConfiguration);
	}

	public static void updateStagingRequest(
			long stagingRequestId, String fileName, byte[] bytes)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStagingRequest(stagingRequestId, fileName, bytes);
	}

	public static StagingService getService() {
		if (_service == null) {
			_service = (StagingService)PortalBeanLocatorUtil.locate(
				StagingService.class.getName());
		}

		return _service;
	}

	private static StagingService _service;

}