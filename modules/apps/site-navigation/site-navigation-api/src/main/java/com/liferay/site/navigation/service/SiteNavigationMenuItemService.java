/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.site.navigation.model.SiteNavigationMenuItem;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for SiteNavigationMenuItem. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SiteNavigationMenuItemServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SiteNavigationMenuItemService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SiteNavigationMenuItemServiceUtil} to access the site navigation menu item remote service. Add custom service methods to <code>com.liferay.site.navigation.service.impl.SiteNavigationMenuItemServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public SiteNavigationMenuItem addSiteNavigationMenuItem(
			long groupId, long siteNavigationMenuId,
			long parentSiteNavigationMenuItemId, String type,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException;

	public SiteNavigationMenuItem deleteSiteNavigationMenuItem(
			long siteNavigationMenuItemId)
		throws PortalException;

	public void deleteSiteNavigationMenuItems(long siteNavigationMenuId)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SiteNavigationMenuItem> getSiteNavigationMenuItems(
		long siteNavigationMenuId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SiteNavigationMenuItem> getSiteNavigationMenuItems(
			long siteNavigationMenuId, long parentSiteNavigationMenuItemId)
		throws PortalException;

	public SiteNavigationMenuItem updateSiteNavigationMenuItem(
			long siteNavigationMenuId, long parentSiteNavigationMenuItemId,
			int order)
		throws PortalException;

	public SiteNavigationMenuItem updateSiteNavigationMenuItem(
			long siteNavigationMenuId, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException;

}