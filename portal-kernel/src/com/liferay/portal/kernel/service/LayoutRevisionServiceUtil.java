/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for LayoutRevision. This utility wraps
 * <code>com.liferay.portal.service.impl.LayoutRevisionServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see LayoutRevisionService
 * @generated
 */
public class LayoutRevisionServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.LayoutRevisionServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.LayoutRevision
			addLayoutRevision(
				long userId, long layoutSetBranchId, long layoutBranchId,
				long parentLayoutRevisionId, boolean head, long plid,
				long portletPreferencesPlid, boolean privateLayout, String name,
				String title, String description, String keywords,
				String robots, String typeSettings, boolean iconImage,
				long iconImageId, String themeId, String colorSchemeId,
				String css, ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addLayoutRevision(
			userId, layoutSetBranchId, layoutBranchId, parentLayoutRevisionId,
			head, plid, portletPreferencesPlid, privateLayout, name, title,
			description, keywords, robots, typeSettings, iconImage, iconImageId,
			themeId, colorSchemeId, css, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static LayoutRevisionService getService() {
		if (_service == null) {
			_service = (LayoutRevisionService)PortalBeanLocatorUtil.locate(
				LayoutRevisionService.class.getName());
		}

		return _service;
	}

	private static LayoutRevisionService _service;

}