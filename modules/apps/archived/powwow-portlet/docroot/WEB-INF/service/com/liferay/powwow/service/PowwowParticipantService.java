/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.powwow.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.powwow.model.PowwowParticipant;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for PowwowParticipant. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Shinn Lok
 * @see PowwowParticipantServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PowwowParticipantService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PowwowParticipantServiceUtil} to access the powwow participant remote service. Add custom service methods to <code>com.liferay.powwow.service.impl.PowwowParticipantServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public PowwowParticipant deletePowwowParticipant(
			PowwowParticipant powwowParticipant)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PowwowParticipant> getPowwowParticipants(long powwowMeetingId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPowwowParticipantsCount(long powwowMeetingId)
		throws PortalException;

	public PowwowParticipant updatePowwowParticipant(
			long powwowParticipantId, long powwowMeetingId, String name,
			long participantUserId, String emailAddress, int type, int status,
			ServiceContext serviceContext)
		throws PortalException;

}