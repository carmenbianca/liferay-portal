/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.external.reference.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ERAssetCategory. This utility wraps
 * <code>com.liferay.external.reference.service.impl.ERAssetCategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ERAssetCategoryLocalService
 * @generated
 */
public class ERAssetCategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.external.reference.service.impl.ERAssetCategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.asset.kernel.model.AssetCategory
			addOrUpdateCategory(
				String externalReferenceCode, long userId, long groupId,
				long parentCategoryId,
				java.util.Map<java.util.Locale, String> titleMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				long vocabularyId, String[] categoryProperties,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addOrUpdateCategory(
			externalReferenceCode, userId, groupId, parentCategoryId, titleMap,
			descriptionMap, vocabularyId, categoryProperties, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ERAssetCategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ERAssetCategoryLocalService, ERAssetCategoryLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ERAssetCategoryLocalService.class);

		ServiceTracker<ERAssetCategoryLocalService, ERAssetCategoryLocalService>
			serviceTracker =
				new ServiceTracker
					<ERAssetCategoryLocalService, ERAssetCategoryLocalService>(
						bundle.getBundleContext(),
						ERAssetCategoryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}