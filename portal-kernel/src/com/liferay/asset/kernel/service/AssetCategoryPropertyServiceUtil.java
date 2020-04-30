/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for AssetCategoryProperty. This utility wraps
 * <code>com.liferay.portlet.asset.service.impl.AssetCategoryPropertyServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AssetCategoryPropertyService
 * @deprecated As of Judson (7.1.x), replaced by {@link
 com.liferay.asset.category.property.service.impl.AssetCategoryPropertyServiceImpl}
 * @generated
 */
@Deprecated
public class AssetCategoryPropertyServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portlet.asset.service.impl.AssetCategoryPropertyServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.asset.kernel.model.AssetCategoryProperty
			addCategoryProperty(long entryId, String key, String value)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCategoryProperty(entryId, key, value);
	}

	public static void deleteCategoryProperty(long categoryPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCategoryProperty(categoryPropertyId);
	}

	public static java.util.List
		<com.liferay.asset.kernel.model.AssetCategoryProperty>
			getCategoryProperties(long entryId) {

		return getService().getCategoryProperties(entryId);
	}

	public static java.util.List
		<com.liferay.asset.kernel.model.AssetCategoryProperty>
			getCategoryPropertyValues(long companyId, String key) {

		return getService().getCategoryPropertyValues(companyId, key);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.asset.kernel.model.AssetCategoryProperty
			updateCategoryProperty(
				long userId, long categoryPropertyId, String key, String value)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateCategoryProperty(
			userId, categoryPropertyId, key, value);
	}

	public static com.liferay.asset.kernel.model.AssetCategoryProperty
			updateCategoryProperty(
				long categoryPropertyId, String key, String value)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateCategoryProperty(
			categoryPropertyId, key, value);
	}

	public static AssetCategoryPropertyService getService() {
		if (_service == null) {
			_service =
				(AssetCategoryPropertyService)PortalBeanLocatorUtil.locate(
					AssetCategoryPropertyService.class.getName());
		}

		return _service;
	}

	private static AssetCategoryPropertyService _service;

}