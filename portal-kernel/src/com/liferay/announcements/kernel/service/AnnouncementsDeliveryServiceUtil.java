/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.announcements.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for AnnouncementsDelivery. This utility wraps
 * <code>com.liferay.portlet.announcements.service.impl.AnnouncementsDeliveryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AnnouncementsDeliveryService
 * @generated
 */
public class AnnouncementsDeliveryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portlet.announcements.service.impl.AnnouncementsDeliveryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.announcements.kernel.model.AnnouncementsDelivery
			updateDelivery(long userId, String type, boolean email, boolean sms)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateDelivery(userId, type, email, sms);
	}

	public static AnnouncementsDeliveryService getService() {
		if (_service == null) {
			_service =
				(AnnouncementsDeliveryService)PortalBeanLocatorUtil.locate(
					AnnouncementsDeliveryService.class.getName());
		}

		return _service;
	}

	private static AnnouncementsDeliveryService _service;

}