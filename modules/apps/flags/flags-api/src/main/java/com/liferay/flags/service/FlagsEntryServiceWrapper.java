/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.flags.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FlagsEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlagsEntryService
 * @generated
 */
public class FlagsEntryServiceWrapper
	implements FlagsEntryService, ServiceWrapper<FlagsEntryService> {

	public FlagsEntryServiceWrapper(FlagsEntryService flagsEntryService) {
		_flagsEntryService = flagsEntryService;
	}

	@Override
	public void addEntry(
			String className, long classPK, String reporterEmailAddress,
			long reportedUserId, String contentTitle, String contentURL,
			String reason,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_flagsEntryService.addEntry(
			className, classPK, reporterEmailAddress, reportedUserId,
			contentTitle, contentURL, reason, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _flagsEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public FlagsEntryService getWrappedService() {
		return _flagsEntryService;
	}

	@Override
	public void setWrappedService(FlagsEntryService flagsEntryService) {
		_flagsEntryService = flagsEntryService;
	}

	private FlagsEntryService _flagsEntryService;

}