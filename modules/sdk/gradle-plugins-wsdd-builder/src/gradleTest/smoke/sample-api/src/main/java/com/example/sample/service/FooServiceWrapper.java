/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.example.sample.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FooService}.
 *
 * @author Brian Wing Shun Chan
 * @see FooService
 * @generated
 */
public class FooServiceWrapper
	implements FooService, ServiceWrapper<FooService> {

	public FooServiceWrapper(FooService fooService) {
		_fooService = fooService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fooService.getOSGiServiceIdentifier();
	}

	@Override
	public FooService getWrappedService() {
		return _fooService;
	}

	@Override
	public void setWrappedService(FooService fooService) {
		_fooService = fooService;
	}

	private FooService _fooService;

}