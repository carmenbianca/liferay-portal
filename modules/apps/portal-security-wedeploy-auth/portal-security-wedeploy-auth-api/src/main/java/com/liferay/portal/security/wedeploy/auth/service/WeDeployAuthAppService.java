/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.wedeploy.auth.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for WeDeployAuthApp. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Supritha Sundaram
 * @see WeDeployAuthAppServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface WeDeployAuthAppService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WeDeployAuthAppServiceUtil} to access the we deploy auth app remote service. Add custom service methods to <code>com.liferay.portal.security.wedeploy.auth.service.impl.WeDeployAuthAppServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public WeDeployAuthApp addWeDeployAuthApp(
			String name, String redirectURI, ServiceContext serviceContext)
		throws PortalException;

	public WeDeployAuthApp deleteWeDeployAuthApp(long weDeployAuthAppId)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}