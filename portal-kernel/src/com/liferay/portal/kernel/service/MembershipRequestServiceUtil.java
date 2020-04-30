/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for MembershipRequest. This utility wraps
 * <code>com.liferay.portal.service.impl.MembershipRequestServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MembershipRequestService
 * @generated
 */
public class MembershipRequestServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.MembershipRequestServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.MembershipRequest
			addMembershipRequest(
				long groupId, String comments, ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addMembershipRequest(
			groupId, comments, serviceContext);
	}

	public static void deleteMembershipRequests(long groupId, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteMembershipRequests(groupId, statusId);
	}

	public static com.liferay.portal.kernel.model.MembershipRequest
			getMembershipRequest(long membershipRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMembershipRequest(membershipRequestId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void updateStatus(
			long membershipRequestId, String reviewComments, long statusId,
			ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(
			membershipRequestId, reviewComments, statusId, serviceContext);
	}

	public static MembershipRequestService getService() {
		if (_service == null) {
			_service = (MembershipRequestService)PortalBeanLocatorUtil.locate(
				MembershipRequestService.class.getName());
		}

		return _service;
	}

	private static MembershipRequestService _service;

}