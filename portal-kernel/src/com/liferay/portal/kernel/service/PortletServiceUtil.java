/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for Portlet. This utility wraps
 * <code>com.liferay.portal.service.impl.PortletServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PortletService
 * @generated
 */
public class PortletServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.PortletServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONArray getWARPortlets() {
		return getService().getWARPortlets();
	}

	public static com.liferay.portal.kernel.model.Portlet updatePortlet(
			long companyId, String portletId, String roles, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePortlet(companyId, portletId, roles, active);
	}

	public static PortletService getService() {
		if (_service == null) {
			_service = (PortletService)PortalBeanLocatorUtil.locate(
				PortletService.class.getName());
		}

		return _service;
	}

	private static PortletService _service;

}