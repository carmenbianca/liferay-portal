/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for Contact. This utility wraps
 * <code>com.liferay.portal.service.impl.ContactServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ContactService
 * @generated
 */
public class ContactServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.ContactServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List<com.liferay.portal.kernel.model.Contact>
			getCompanyContacts(long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCompanyContacts(companyId, start, end);
	}

	public static int getCompanyContactsCount(long companyId) {
		return getService().getCompanyContactsCount(companyId);
	}

	public static com.liferay.portal.kernel.model.Contact getContact(
			long contactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getContact(contactId);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Contact>
			getContacts(
				long classNameId, long classPK, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.portal.kernel.model.Contact> orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getContacts(
			classNameId, classPK, start, end, orderByComparator);
	}

	public static int getContactsCount(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getContactsCount(classNameId, classPK);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ContactService getService() {
		if (_service == null) {
			_service = (ContactService)PortalBeanLocatorUtil.locate(
				ContactService.class.getName());
		}

		return _service;
	}

	private static ContactService _service;

}