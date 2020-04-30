/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for DDMDataProviderInstance. This utility wraps
 * <code>com.liferay.dynamic.data.mapping.service.impl.DDMDataProviderInstanceServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DDMDataProviderInstanceService
 * @generated
 */
public class DDMDataProviderInstanceServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.dynamic.data.mapping.service.impl.DDMDataProviderInstanceServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance
			addDataProviderInstance(
				long groupId, java.util.Map<java.util.Locale, String> nameMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				com.liferay.dynamic.data.mapping.storage.DDMFormValues
					ddmFormValues,
				String type,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addDataProviderInstance(
			groupId, nameMap, descriptionMap, ddmFormValues, type,
			serviceContext);
	}

	public static void deleteDataProviderInstance(long dataProviderInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteDataProviderInstance(dataProviderInstanceId);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance
			fetchDataProviderInstance(long dataProviderInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchDataProviderInstance(dataProviderInstanceId);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance
			fetchDataProviderInstanceByUuid(String uuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchDataProviderInstanceByUuid(uuid);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance
			getDataProviderInstance(long dataProviderInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataProviderInstance(dataProviderInstanceId);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance
			getDataProviderInstanceByUuid(String uuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDataProviderInstanceByUuid(uuid);
	}

	public static java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance>
			getDataProviderInstances(
				long companyId, long[] groupIds, int start, int end) {

		return getService().getDataProviderInstances(
			companyId, groupIds, start, end);
	}

	public static int getDataProviderInstancesCount(
		long companyId, long[] groupIds) {

		return getService().getDataProviderInstancesCount(companyId, groupIds);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance> search(
			long companyId, long[] groupIds, String keywords, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance>
					orderByComparator) {

		return getService().search(
			companyId, groupIds, keywords, start, end, orderByComparator);
	}

	public static java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance> search(
			long companyId, long[] groupIds, String name, String description,
			boolean andOperator, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance>
					orderByComparator) {

		return getService().search(
			companyId, groupIds, name, description, andOperator, start, end,
			orderByComparator);
	}

	public static int searchCount(
		long companyId, long[] groupIds, String keywords) {

		return getService().searchCount(companyId, groupIds, keywords);
	}

	public static int searchCount(
		long companyId, long[] groupIds, String name, String description,
		boolean andOperator) {

		return getService().searchCount(
			companyId, groupIds, name, description, andOperator);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance
			updateDataProviderInstance(
				long dataProviderInstanceId,
				java.util.Map<java.util.Locale, String> nameMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				com.liferay.dynamic.data.mapping.storage.DDMFormValues
					ddmFormValues,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateDataProviderInstance(
			dataProviderInstanceId, nameMap, descriptionMap, ddmFormValues,
			serviceContext);
	}

	public static DDMDataProviderInstanceService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DDMDataProviderInstanceService, DDMDataProviderInstanceService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DDMDataProviderInstanceService.class);

		ServiceTracker
			<DDMDataProviderInstanceService, DDMDataProviderInstanceService>
				serviceTracker =
					new ServiceTracker
						<DDMDataProviderInstanceService,
						 DDMDataProviderInstanceService>(
							 bundle.getBundleContext(),
							 DDMDataProviderInstanceService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}