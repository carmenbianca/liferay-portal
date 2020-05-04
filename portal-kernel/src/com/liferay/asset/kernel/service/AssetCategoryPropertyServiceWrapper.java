/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.service;

import com.liferay.asset.kernel.model.AssetCategoryProperty;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssetCategoryPropertyService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssetCategoryPropertyService
 * @deprecated As of Judson (7.1.x), replaced by {@link
 com.liferay.asset.category.property.service.impl.AssetCategoryPropertyServiceImpl}
 * @generated
 */
@Deprecated
public class AssetCategoryPropertyServiceWrapper
	implements AssetCategoryPropertyService,
			   ServiceWrapper<AssetCategoryPropertyService> {

	public AssetCategoryPropertyServiceWrapper(
		AssetCategoryPropertyService assetCategoryPropertyService) {

		_assetCategoryPropertyService = assetCategoryPropertyService;
	}

	@Override
	public AssetCategoryProperty addCategoryProperty(
			long entryId, String key, String value)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assetCategoryPropertyService.addCategoryProperty(
			entryId, key, value);
	}

	@Override
	public void deleteCategoryProperty(long categoryPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_assetCategoryPropertyService.deleteCategoryProperty(
			categoryPropertyId);
	}

	@Override
	public java.util.List<AssetCategoryProperty> getCategoryProperties(
		long entryId) {

		return _assetCategoryPropertyService.getCategoryProperties(entryId);
	}

	@Override
	public java.util.List<AssetCategoryProperty> getCategoryPropertyValues(
		long companyId, String key) {

		return _assetCategoryPropertyService.getCategoryPropertyValues(
			companyId, key);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _assetCategoryPropertyService.getOSGiServiceIdentifier();
	}

	@Override
	public AssetCategoryProperty updateCategoryProperty(
			long userId, long categoryPropertyId, String key, String value)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assetCategoryPropertyService.updateCategoryProperty(
			userId, categoryPropertyId, key, value);
	}

	@Override
	public AssetCategoryProperty updateCategoryProperty(
			long categoryPropertyId, String key, String value)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assetCategoryPropertyService.updateCategoryProperty(
			categoryPropertyId, key, value);
	}

	@Override
	public AssetCategoryPropertyService getWrappedService() {
		return _assetCategoryPropertyService;
	}

	@Override
	public void setWrappedService(
		AssetCategoryPropertyService assetCategoryPropertyService) {

		_assetCategoryPropertyService = assetCategoryPropertyService;
	}

	private AssetCategoryPropertyService _assetCategoryPropertyService;

}