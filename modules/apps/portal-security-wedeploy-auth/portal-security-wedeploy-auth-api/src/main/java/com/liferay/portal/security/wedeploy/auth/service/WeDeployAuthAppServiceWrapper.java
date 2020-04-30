/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.wedeploy.auth.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WeDeployAuthAppService}.
 *
 * @author Supritha Sundaram
 * @see WeDeployAuthAppService
 * @generated
 */
public class WeDeployAuthAppServiceWrapper
	implements ServiceWrapper<WeDeployAuthAppService>, WeDeployAuthAppService {

	public WeDeployAuthAppServiceWrapper(
		WeDeployAuthAppService weDeployAuthAppService) {

		_weDeployAuthAppService = weDeployAuthAppService;
	}

	@Override
	public com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp
			addWeDeployAuthApp(
				String name, String redirectURI,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _weDeployAuthAppService.addWeDeployAuthApp(
			name, redirectURI, serviceContext);
	}

	@Override
	public com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp
			deleteWeDeployAuthApp(long weDeployAuthAppId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _weDeployAuthAppService.deleteWeDeployAuthApp(weDeployAuthAppId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _weDeployAuthAppService.getOSGiServiceIdentifier();
	}

	@Override
	public WeDeployAuthAppService getWrappedService() {
		return _weDeployAuthAppService;
	}

	@Override
	public void setWrappedService(
		WeDeployAuthAppService weDeployAuthAppService) {

		_weDeployAuthAppService = weDeployAuthAppService;
	}

	private WeDeployAuthAppService _weDeployAuthAppService;

}