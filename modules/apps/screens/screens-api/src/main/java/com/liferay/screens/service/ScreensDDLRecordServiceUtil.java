/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.screens.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ScreensDDLRecord. This utility wraps
 * <code>com.liferay.screens.service.impl.ScreensDDLRecordServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author José Manuel Navarro
 * @see ScreensDDLRecordService
 * @generated
 */
public class ScreensDDLRecordServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.screens.service.impl.ScreensDDLRecordServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONObject getDDLRecord(
			long ddlRecordId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDDLRecord(ddlRecordId, locale);
	}

	public static com.liferay.portal.kernel.json.JSONArray getDDLRecords(
			long ddlRecordSetId, java.util.Locale locale, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.dynamic.data.lists.model.DDLRecord> obc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDDLRecords(
			ddlRecordSetId, locale, start, end, obc);
	}

	public static com.liferay.portal.kernel.json.JSONArray getDDLRecords(
			long ddlRecordSetId, long userId, java.util.Locale locale,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.dynamic.data.lists.model.DDLRecord> obc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDDLRecords(
			ddlRecordSetId, userId, locale, start, end, obc);
	}

	public static int getDDLRecordsCount(long ddlRecordSetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDDLRecordsCount(ddlRecordSetId);
	}

	public static int getDDLRecordsCount(long ddlRecordSetId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDDLRecordsCount(ddlRecordSetId, userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ScreensDDLRecordService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ScreensDDLRecordService, ScreensDDLRecordService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ScreensDDLRecordService.class);

		ServiceTracker<ScreensDDLRecordService, ScreensDDLRecordService>
			serviceTracker =
				new ServiceTracker
					<ScreensDDLRecordService, ScreensDDLRecordService>(
						bundle.getBundleContext(),
						ScreensDDLRecordService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}