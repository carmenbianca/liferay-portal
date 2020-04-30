/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for DDMFormInstanceRecord. This utility wraps
 * <code>com.liferay.dynamic.data.mapping.service.impl.DDMFormInstanceRecordServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DDMFormInstanceRecordService
 * @generated
 */
public class DDMFormInstanceRecordServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.dynamic.data.mapping.service.impl.DDMFormInstanceRecordServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord
			addFormInstanceRecord(
				long groupId, long ddmFormInstanceId,
				com.liferay.dynamic.data.mapping.storage.DDMFormValues
					ddmFormValues,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addFormInstanceRecord(
			groupId, ddmFormInstanceId, ddmFormValues, serviceContext);
	}

	public static void deleteFormInstanceRecord(long ddmFormInstanceRecordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteFormInstanceRecord(ddmFormInstanceRecordId);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord
			getFormInstanceRecord(long ddmFormInstanceRecordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFormInstanceRecord(ddmFormInstanceRecordId);
	}

	public static java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord>
				getFormInstanceRecords(long ddmFormInstanceId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFormInstanceRecords(ddmFormInstanceId);
	}

	public static java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord>
				getFormInstanceRecords(
					long ddmFormInstanceId, int status, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.liferay.dynamic.data.mapping.model.
							DDMFormInstanceRecord> orderByComparator)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFormInstanceRecords(
			ddmFormInstanceId, status, start, end, orderByComparator);
	}

	public static int getFormInstanceRecordsCount(long ddmFormInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFormInstanceRecordsCount(ddmFormInstanceId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void revertFormInstanceRecord(
			long ddmFormInstanceRecordId, String version,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().revertFormInstanceRecord(
			ddmFormInstanceRecordId, version, serviceContext);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord
			updateFormInstanceRecord(
				long ddmFormInstanceRecordId, boolean majorVersion,
				com.liferay.dynamic.data.mapping.storage.DDMFormValues
					ddmFormValues,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateFormInstanceRecord(
			ddmFormInstanceRecordId, majorVersion, ddmFormValues,
			serviceContext);
	}

	public static DDMFormInstanceRecordService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DDMFormInstanceRecordService, DDMFormInstanceRecordService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DDMFormInstanceRecordService.class);

		ServiceTracker
			<DDMFormInstanceRecordService, DDMFormInstanceRecordService>
				serviceTracker =
					new ServiceTracker
						<DDMFormInstanceRecordService,
						 DDMFormInstanceRecordService>(
							 bundle.getBundleContext(),
							 DDMFormInstanceRecordService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}