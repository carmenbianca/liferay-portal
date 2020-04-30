/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for OrgLabor. This utility wraps
 * <code>com.liferay.portal.service.impl.OrgLaborServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see OrgLaborService
 * @generated
 */
public class OrgLaborServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.OrgLaborServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.OrgLabor addOrgLabor(
			long organizationId, long typeId, int sunOpen, int sunClose,
			int monOpen, int monClose, int tueOpen, int tueClose, int wedOpen,
			int wedClose, int thuOpen, int thuClose, int friOpen, int friClose,
			int satOpen, int satClose)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addOrgLabor(
			organizationId, typeId, sunOpen, sunClose, monOpen, monClose,
			tueOpen, tueClose, wedOpen, wedClose, thuOpen, thuClose, friOpen,
			friClose, satOpen, satClose);
	}

	public static void deleteOrgLabor(long orgLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteOrgLabor(orgLaborId);
	}

	public static com.liferay.portal.kernel.model.OrgLabor getOrgLabor(
			long orgLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getOrgLabor(orgLaborId);
	}

	public static java.util.List<com.liferay.portal.kernel.model.OrgLabor>
			getOrgLabors(long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getOrgLabors(organizationId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.OrgLabor updateOrgLabor(
			long orgLaborId, long typeId, int sunOpen, int sunClose,
			int monOpen, int monClose, int tueOpen, int tueClose, int wedOpen,
			int wedClose, int thuOpen, int thuClose, int friOpen, int friClose,
			int satOpen, int satClose)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateOrgLabor(
			orgLaborId, typeId, sunOpen, sunClose, monOpen, monClose, tueOpen,
			tueClose, wedOpen, wedClose, thuOpen, thuClose, friOpen, friClose,
			satOpen, satClose);
	}

	public static OrgLaborService getService() {
		if (_service == null) {
			_service = (OrgLaborService)PortalBeanLocatorUtil.locate(
				OrgLaborService.class.getName());
		}

		return _service;
	}

	private static OrgLaborService _service;

}