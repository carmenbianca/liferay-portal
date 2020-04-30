/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for ListType. This utility wraps
 * <code>com.liferay.portal.service.impl.ListTypeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ListTypeService
 * @generated
 */
public class ListTypeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.ListTypeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.ListType getListType(
			long listTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getListType(listTypeId);
	}

	public static com.liferay.portal.kernel.model.ListType getListType(
		String name, String type) {

		return getService().getListType(name, type);
	}

	public static java.util.List<com.liferay.portal.kernel.model.ListType>
		getListTypes(String type) {

		return getService().getListTypes(type);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void validate(long listTypeId, long classNameId, String type)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().validate(listTypeId, classNameId, type);
	}

	public static void validate(long listTypeId, String type)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().validate(listTypeId, type);
	}

	public static ListTypeService getService() {
		if (_service == null) {
			_service = (ListTypeService)PortalBeanLocatorUtil.locate(
				ListTypeService.class.getName());
		}

		return _service;
	}

	private static ListTypeService _service;

}