/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DispatchLogService}.
 *
 * @author Alessio Antonio Rendina
 * @see DispatchLogService
 * @generated
 */
public class DispatchLogServiceWrapper
	implements DispatchLogService, ServiceWrapper<DispatchLogService> {

	public DispatchLogServiceWrapper(DispatchLogService dispatchLogService) {
		_dispatchLogService = dispatchLogService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dispatchLogService.getOSGiServiceIdentifier();
	}

	@Override
	public DispatchLogService getWrappedService() {
		return _dispatchLogService;
	}

	@Override
	public void setWrappedService(DispatchLogService dispatchLogService) {
		_dispatchLogService = dispatchLogService;
	}

	private DispatchLogService _dispatchLogService;

}