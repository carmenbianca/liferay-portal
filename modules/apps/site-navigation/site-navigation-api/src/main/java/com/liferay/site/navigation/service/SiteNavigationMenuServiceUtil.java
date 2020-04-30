/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for SiteNavigationMenu. This utility wraps
 * <code>com.liferay.site.navigation.service.impl.SiteNavigationMenuServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SiteNavigationMenuService
 * @generated
 */
public class SiteNavigationMenuServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.site.navigation.service.impl.SiteNavigationMenuServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.site.navigation.model.SiteNavigationMenu
			addSiteNavigationMenu(
				long groupId, String name, int type, boolean auto,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addSiteNavigationMenu(
			groupId, name, type, auto, serviceContext);
	}

	public static com.liferay.site.navigation.model.SiteNavigationMenu
			addSiteNavigationMenu(
				long groupId, String name, int type,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addSiteNavigationMenu(
			groupId, name, type, serviceContext);
	}

	public static com.liferay.site.navigation.model.SiteNavigationMenu
			addSiteNavigationMenu(
				long groupId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addSiteNavigationMenu(
			groupId, name, serviceContext);
	}

	public static com.liferay.site.navigation.model.SiteNavigationMenu
			deleteSiteNavigationMenu(long siteNavigationMenuId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSiteNavigationMenu(siteNavigationMenuId);
	}

	public static com.liferay.site.navigation.model.SiteNavigationMenu
			fetchSiteNavigationMenu(long siteNavigationMenuId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchSiteNavigationMenu(siteNavigationMenuId);
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
		<com.liferay.site.navigation.model.SiteNavigationMenu>
			getSiteNavigationMenus(long groupId) {

		return getService().getSiteNavigationMenus(groupId);
	}

	public static java.util.List
		<com.liferay.site.navigation.model.SiteNavigationMenu>
			getSiteNavigationMenus(
				long groupId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					orderByComparator) {

		return getService().getSiteNavigationMenus(
			groupId, start, end, orderByComparator);
	}

	public static java.util.List
		<com.liferay.site.navigation.model.SiteNavigationMenu>
			getSiteNavigationMenus(
				long groupId, String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					orderByComparator) {

		return getService().getSiteNavigationMenus(
			groupId, keywords, start, end, orderByComparator);
	}

	public static java.util.List
		<com.liferay.site.navigation.model.SiteNavigationMenu>
			getSiteNavigationMenus(
				long[] groupIds, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					orderByComparator) {

		return getService().getSiteNavigationMenus(
			groupIds, start, end, orderByComparator);
	}

	public static java.util.List
		<com.liferay.site.navigation.model.SiteNavigationMenu>
			getSiteNavigationMenus(
				long[] groupIds, String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					orderByComparator) {

		return getService().getSiteNavigationMenus(
			groupIds, keywords, start, end, orderByComparator);
	}

	public static int getSiteNavigationMenusCount(long groupId) {
		return getService().getSiteNavigationMenusCount(groupId);
	}

	public static int getSiteNavigationMenusCount(
		long groupId, String keywords) {

		return getService().getSiteNavigationMenusCount(groupId, keywords);
	}

	public static int getSiteNavigationMenusCount(long[] groupIds) {
		return getService().getSiteNavigationMenusCount(groupIds);
	}

	public static int getSiteNavigationMenusCount(
		long[] groupIds, String keywords) {

		return getService().getSiteNavigationMenusCount(groupIds, keywords);
	}

	public static com.liferay.site.navigation.model.SiteNavigationMenu
			updateSiteNavigationMenu(
				long siteNavigationMenuId, int type, boolean auto,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateSiteNavigationMenu(
			siteNavigationMenuId, type, auto, serviceContext);
	}

	public static com.liferay.site.navigation.model.SiteNavigationMenu
			updateSiteNavigationMenu(
				long siteNavigationMenuId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateSiteNavigationMenu(
			siteNavigationMenuId, name, serviceContext);
	}

	public static SiteNavigationMenuService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SiteNavigationMenuService, SiteNavigationMenuService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SiteNavigationMenuService.class);

		ServiceTracker<SiteNavigationMenuService, SiteNavigationMenuService>
			serviceTracker =
				new ServiceTracker
					<SiteNavigationMenuService, SiteNavigationMenuService>(
						bundle.getBundleContext(),
						SiteNavigationMenuService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}