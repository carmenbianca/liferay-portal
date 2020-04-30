/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.external.reference.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ERAssetCategoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ERAssetCategoryLocalService
 * @generated
 */
public class ERAssetCategoryLocalServiceWrapper
	implements ERAssetCategoryLocalService,
			   ServiceWrapper<ERAssetCategoryLocalService> {

	public ERAssetCategoryLocalServiceWrapper(
		ERAssetCategoryLocalService erAssetCategoryLocalService) {

		_erAssetCategoryLocalService = erAssetCategoryLocalService;
	}

	@Override
	public com.liferay.asset.kernel.model.AssetCategory addOrUpdateCategory(
			String externalReferenceCode, long userId, long groupId,
			long parentCategoryId,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			long vocabularyId, String[] categoryProperties,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _erAssetCategoryLocalService.addOrUpdateCategory(
			externalReferenceCode, userId, groupId, parentCategoryId, titleMap,
			descriptionMap, vocabularyId, categoryProperties, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _erAssetCategoryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public ERAssetCategoryLocalService getWrappedService() {
		return _erAssetCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		ERAssetCategoryLocalService erAssetCategoryLocalService) {

		_erAssetCategoryLocalService = erAssetCategoryLocalService;
	}

	private ERAssetCategoryLocalService _erAssetCategoryLocalService;

}