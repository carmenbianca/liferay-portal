/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for LayoutPrototype. This utility wraps
 * <code>com.liferay.portal.service.impl.LayoutPrototypeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPrototypeService
 * @generated
 */
public class LayoutPrototypeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.LayoutPrototypeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.LayoutPrototype
			addLayoutPrototype(
				java.util.Map<java.util.Locale, String> nameMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				boolean active, ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addLayoutPrototype(
			nameMap, descriptionMap, active, serviceContext);
	}

	public static void deleteLayoutPrototype(long layoutPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteLayoutPrototype(layoutPrototypeId);
	}

	public static com.liferay.portal.kernel.model.LayoutPrototype
			fetchLayoutPrototype(long layoutPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchLayoutPrototype(layoutPrototypeId);
	}

	public static com.liferay.portal.kernel.model.LayoutPrototype
			getLayoutPrototype(long layoutPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLayoutPrototype(layoutPrototypeId);
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
		<com.liferay.portal.kernel.model.LayoutPrototype> search(
				long companyId, Boolean active,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.portal.kernel.model.LayoutPrototype> obc)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().search(companyId, active, obc);
	}

	public static com.liferay.portal.kernel.model.LayoutPrototype
			updateLayoutPrototype(
				long layoutPrototypeId,
				java.util.Map<java.util.Locale, String> nameMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				boolean active, ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateLayoutPrototype(
			layoutPrototypeId, nameMap, descriptionMap, active, serviceContext);
	}

	public static LayoutPrototypeService getService() {
		if (_service == null) {
			_service = (LayoutPrototypeService)PortalBeanLocatorUtil.locate(
				LayoutPrototypeService.class.getName());
		}

		return _service;
	}

	private static LayoutPrototypeService _service;

}