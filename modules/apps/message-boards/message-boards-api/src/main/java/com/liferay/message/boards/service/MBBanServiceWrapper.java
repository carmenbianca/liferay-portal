/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MBBanService}.
 *
 * @author Brian Wing Shun Chan
 * @see MBBanService
 * @generated
 */
public class MBBanServiceWrapper
	implements MBBanService, ServiceWrapper<MBBanService> {

	public MBBanServiceWrapper(MBBanService mbBanService) {
		_mbBanService = mbBanService;
	}

	@Override
	public com.liferay.message.boards.model.MBBan addBan(
			long banUserId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mbBanService.addBan(banUserId, serviceContext);
	}

	@Override
	public void deleteBan(
			long banUserId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_mbBanService.deleteBan(banUserId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mbBanService.getOSGiServiceIdentifier();
	}

	@Override
	public MBBanService getWrappedService() {
		return _mbBanService;
	}

	@Override
	public void setWrappedService(MBBanService mbBanService) {
		_mbBanService = mbBanService;
	}

	private MBBanService _mbBanService;

}