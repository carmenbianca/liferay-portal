/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UADPartialEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see UADPartialEntryService
 * @generated
 */
public class UADPartialEntryServiceWrapper
	implements ServiceWrapper<UADPartialEntryService>, UADPartialEntryService {

	public UADPartialEntryServiceWrapper(
		UADPartialEntryService uadPartialEntryService) {

		_uadPartialEntryService = uadPartialEntryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _uadPartialEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public UADPartialEntryService getWrappedService() {
		return _uadPartialEntryService;
	}

	@Override
	public void setWrappedService(
		UADPartialEntryService uadPartialEntryService) {

		_uadPartialEntryService = uadPartialEntryService;
	}

	private UADPartialEntryService _uadPartialEntryService;

}