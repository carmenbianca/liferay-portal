/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.service.builder.test.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EagerBlobEntityService}.
 *
 * @author Brian Wing Shun Chan
 * @see EagerBlobEntityService
 * @generated
 */
public class EagerBlobEntityServiceWrapper
	implements EagerBlobEntityService, ServiceWrapper<EagerBlobEntityService> {

	public EagerBlobEntityServiceWrapper(
		EagerBlobEntityService eagerBlobEntityService) {

		_eagerBlobEntityService = eagerBlobEntityService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eagerBlobEntityService.getOSGiServiceIdentifier();
	}

	@Override
	public EagerBlobEntityService getWrappedService() {
		return _eagerBlobEntityService;
	}

	@Override
	public void setWrappedService(
		EagerBlobEntityService eagerBlobEntityService) {

		_eagerBlobEntityService = eagerBlobEntityService;
	}

	private EagerBlobEntityService _eagerBlobEntityService;

}