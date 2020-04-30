/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;

/**
 * Provides the remote service utility for Gadget. This utility wraps
 * <code>com.liferay.opensocial.service.impl.GadgetServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see GadgetService
 * @generated
 */
public class GadgetServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.opensocial.service.impl.GadgetServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.opensocial.model.Gadget addGadget(
			long companyId, String url, String portletCategoryNames,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addGadget(
			companyId, url, portletCategoryNames, serviceContext);
	}

	public static void deleteGadget(
			long gadgetId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteGadget(gadgetId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void updateGadget(
			long gadgetId, String portletCategoryNames,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateGadget(
			gadgetId, portletCategoryNames, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static GadgetService getService() {
		if (_service == null) {
			_service = (GadgetService)PortletBeanLocatorUtil.locate(
				ServletContextUtil.getServletContextName(),
				GadgetService.class.getName());
		}

		return _service;
	}

	private static GadgetService _service;

}