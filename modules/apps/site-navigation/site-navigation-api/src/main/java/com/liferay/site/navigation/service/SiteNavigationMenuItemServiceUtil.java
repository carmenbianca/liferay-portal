/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for SiteNavigationMenuItem. This utility wraps
 * <code>com.liferay.site.navigation.service.impl.SiteNavigationMenuItemServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SiteNavigationMenuItemService
 * @generated
 */
public class SiteNavigationMenuItemServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.site.navigation.service.impl.SiteNavigationMenuItemServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.site.navigation.model.SiteNavigationMenuItem
			addSiteNavigationMenuItem(
				long groupId, long siteNavigationMenuId,
				long parentSiteNavigationMenuItemId, String type,
				String typeSettings,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addSiteNavigationMenuItem(
			groupId, siteNavigationMenuId, parentSiteNavigationMenuItemId, type,
			typeSettings, serviceContext);
	}

	public static com.liferay.site.navigation.model.SiteNavigationMenuItem
			deleteSiteNavigationMenuItem(long siteNavigationMenuItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSiteNavigationMenuItem(
			siteNavigationMenuItemId);
	}

	public static void deleteSiteNavigationMenuItems(long siteNavigationMenuId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteSiteNavigationMenuItems(siteNavigationMenuId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List
		<com.liferay.site.navigation.model.SiteNavigationMenuItem>
			getSiteNavigationMenuItems(long siteNavigationMenuId) {

		return getService().getSiteNavigationMenuItems(siteNavigationMenuId);
	}

	public static java.util.List
		<com.liferay.site.navigation.model.SiteNavigationMenuItem>
				getSiteNavigationMenuItems(
					long siteNavigationMenuId,
					long parentSiteNavigationMenuItemId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSiteNavigationMenuItems(
			siteNavigationMenuId, parentSiteNavigationMenuItemId);
	}

	public static com.liferay.site.navigation.model.SiteNavigationMenuItem
			updateSiteNavigationMenuItem(
				long siteNavigationMenuId, long parentSiteNavigationMenuItemId,
				int order)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateSiteNavigationMenuItem(
			siteNavigationMenuId, parentSiteNavigationMenuItemId, order);
	}

	public static com.liferay.site.navigation.model.SiteNavigationMenuItem
			updateSiteNavigationMenuItem(
				long siteNavigationMenuId, String typeSettings,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateSiteNavigationMenuItem(
			siteNavigationMenuId, typeSettings, serviceContext);
	}

	public static SiteNavigationMenuItemService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SiteNavigationMenuItemService, SiteNavigationMenuItemService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SiteNavigationMenuItemService.class);

		ServiceTracker
			<SiteNavigationMenuItemService, SiteNavigationMenuItemService>
				serviceTracker =
					new ServiceTracker
						<SiteNavigationMenuItemService,
						 SiteNavigationMenuItemService>(
							 bundle.getBundleContext(),
							 SiteNavigationMenuItemService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}