/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

/**
 * Provides a wrapper for {@link MembershipRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see MembershipRequestService
 * @generated
 */
public class MembershipRequestServiceWrapper
	implements MembershipRequestService,
			   ServiceWrapper<MembershipRequestService> {

	public MembershipRequestServiceWrapper(
		MembershipRequestService membershipRequestService) {

		_membershipRequestService = membershipRequestService;
	}

	@Override
	public com.liferay.portal.kernel.model.MembershipRequest
			addMembershipRequest(
				long groupId, java.lang.String comments,
				ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _membershipRequestService.addMembershipRequest(
			groupId, comments, serviceContext);
	}

	@Override
	public void deleteMembershipRequests(long groupId, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_membershipRequestService.deleteMembershipRequests(groupId, statusId);
	}

	@Override
	public com.liferay.portal.kernel.model.MembershipRequest
			getMembershipRequest(long membershipRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _membershipRequestService.getMembershipRequest(
			membershipRequestId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _membershipRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public void updateStatus(
			long membershipRequestId, java.lang.String reviewComments,
			long statusId, ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_membershipRequestService.updateStatus(
			membershipRequestId, reviewComments, statusId, serviceContext);
	}

	@Override
	public MembershipRequestService getWrappedService() {
		return _membershipRequestService;
	}

	@Override
	public void setWrappedService(
		MembershipRequestService membershipRequestService) {

		_membershipRequestService = membershipRequestService;
	}

	private MembershipRequestService _membershipRequestService;

}