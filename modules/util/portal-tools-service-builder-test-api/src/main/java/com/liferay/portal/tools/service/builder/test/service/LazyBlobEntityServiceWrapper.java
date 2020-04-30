/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LazyBlobEntityService}.
 *
 * @author Brian Wing Shun Chan
 * @see LazyBlobEntityService
 * @generated
 */
public class LazyBlobEntityServiceWrapper
	implements LazyBlobEntityService, ServiceWrapper<LazyBlobEntityService> {

	public LazyBlobEntityServiceWrapper(
		LazyBlobEntityService lazyBlobEntityService) {

		_lazyBlobEntityService = lazyBlobEntityService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lazyBlobEntityService.getOSGiServiceIdentifier();
	}

	@Override
	public LazyBlobEntityService getWrappedService() {
		return _lazyBlobEntityService;
	}

	@Override
	public void setWrappedService(LazyBlobEntityService lazyBlobEntityService) {
		_lazyBlobEntityService = lazyBlobEntityService;
	}

	private LazyBlobEntityService _lazyBlobEntityService;

}