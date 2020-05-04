/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DepotEntryGroupRelService}.
 *
 * @author Brian Wing Shun Chan
 * @see DepotEntryGroupRelService
 * @generated
 */
public class DepotEntryGroupRelServiceWrapper
	implements DepotEntryGroupRelService,
			   ServiceWrapper<DepotEntryGroupRelService> {

	public DepotEntryGroupRelServiceWrapper(
		DepotEntryGroupRelService depotEntryGroupRelService) {

		_depotEntryGroupRelService = depotEntryGroupRelService;
	}

	@Override
	public com.liferay.depot.model.DepotEntryGroupRel addDepotEntryGroupRel(
			long depotEntryId, long toGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _depotEntryGroupRelService.addDepotEntryGroupRel(
			depotEntryId, toGroupId);
	}

	@Override
	public com.liferay.depot.model.DepotEntryGroupRel deleteDepotEntryGroupRel(
			long depotEntryGroupRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _depotEntryGroupRelService.deleteDepotEntryGroupRel(
			depotEntryGroupRelId);
	}

	@Override
	public java.util.List<com.liferay.depot.model.DepotEntryGroupRel>
			getDepotEntryGroupRels(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _depotEntryGroupRelService.getDepotEntryGroupRels(
			groupId, start, end);
	}

	@Override
	public int getDepotEntryGroupRelsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _depotEntryGroupRelService.getDepotEntryGroupRelsCount(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _depotEntryGroupRelService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.depot.model.DepotEntryGroupRel updateSearchable(
			long depotEntryGroupRelId, boolean searchable)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _depotEntryGroupRelService.updateSearchable(
			depotEntryGroupRelId, searchable);
	}

	@Override
	public DepotEntryGroupRelService getWrappedService() {
		return _depotEntryGroupRelService;
	}

	@Override
	public void setWrappedService(
		DepotEntryGroupRelService depotEntryGroupRelService) {

		_depotEntryGroupRelService = depotEntryGroupRelService;
	}

	private DepotEntryGroupRelService _depotEntryGroupRelService;

}