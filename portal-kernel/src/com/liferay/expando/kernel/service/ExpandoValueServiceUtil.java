/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for ExpandoValue. This utility wraps
 * <code>com.liferay.portlet.expando.service.impl.ExpandoValueServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoValueService
 * @generated
 */
public class ExpandoValueServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portlet.expando.service.impl.ExpandoValueServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.expando.kernel.model.ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, Object data)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	public static com.liferay.expando.kernel.model.ExpandoValue addValue(
			long companyId, String className, String tableName,
			String columnName, long classPK, String data)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addValue(
			companyId, className, tableName, columnName, classPK, data);
	}

	public static void addValues(
			long companyId, String className, String tableName, long classPK,
			java.util.Map<String, java.io.Serializable> attributeValues)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addValues(
			companyId, className, tableName, classPK, attributeValues);
	}

	public static java.util.Map<String, java.io.Serializable> getData(
			long companyId, String className, String tableName,
			java.util.Collection<String> columnNames, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getData(
			companyId, className, tableName, columnNames, classPK);
	}

	public static java.io.Serializable getData(
			long companyId, String className, String tableName,
			String columnName, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getData(
			companyId, className, tableName, columnName, classPK);
	}

	public static com.liferay.portal.kernel.json.JSONObject getJSONData(
			long companyId, String className, String tableName,
			String columnName, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getJSONData(
			companyId, className, tableName, columnName, classPK);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ExpandoValueService getService() {
		if (_service == null) {
			_service = (ExpandoValueService)PortalBeanLocatorUtil.locate(
				ExpandoValueService.class.getName());
		}

		return _service;
	}

	private static ExpandoValueService _service;

}