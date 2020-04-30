/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DispatchTriggerService}.
 *
 * @author Alessio Antonio Rendina
 * @see DispatchTriggerService
 * @generated
 */
public class DispatchTriggerServiceWrapper
	implements DispatchTriggerService, ServiceWrapper<DispatchTriggerService> {

	public DispatchTriggerServiceWrapper(
		DispatchTriggerService dispatchTriggerService) {

		_dispatchTriggerService = dispatchTriggerService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dispatchTriggerService.getOSGiServiceIdentifier();
	}

	@Override
	public DispatchTriggerService getWrappedService() {
		return _dispatchTriggerService;
	}

	@Override
	public void setWrappedService(
		DispatchTriggerService dispatchTriggerService) {

		_dispatchTriggerService = dispatchTriggerService;
	}

	private DispatchTriggerService _dispatchTriggerService;

}