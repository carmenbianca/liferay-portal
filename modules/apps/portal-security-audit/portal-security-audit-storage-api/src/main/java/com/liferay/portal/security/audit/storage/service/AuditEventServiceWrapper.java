/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.audit.storage.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuditEventService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventService
 * @generated
 */
public class AuditEventServiceWrapper
	implements AuditEventService, ServiceWrapper<AuditEventService> {

	public AuditEventServiceWrapper(AuditEventService auditEventService) {
		_auditEventService = auditEventService;
	}

	@Override
	public java.util.List
		<com.liferay.portal.security.audit.storage.model.AuditEvent>
				getAuditEvents(long companyId, int start, int end)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _auditEventService.getAuditEvents(companyId, start, end);
	}

	@Override
	public java.util.List
		<com.liferay.portal.security.audit.storage.model.AuditEvent>
				getAuditEvents(
					long companyId, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						orderByComparator)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _auditEventService.getAuditEvents(
			companyId, start, end, orderByComparator);
	}

	@Override
	public java.util.List
		<com.liferay.portal.security.audit.storage.model.AuditEvent>
				getAuditEvents(
					long companyId, long userId, String userName,
					java.util.Date createDateGT, java.util.Date createDateLT,
					String eventType, String className, String classPK,
					String clientHost, String clientIP, String serverName,
					int serverPort, String sessionID, boolean andSearch,
					int start, int end)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _auditEventService.getAuditEvents(
			companyId, userId, userName, createDateGT, createDateLT, eventType,
			className, classPK, clientHost, clientIP, serverName, serverPort,
			sessionID, andSearch, start, end);
	}

	@Override
	public java.util.List
		<com.liferay.portal.security.audit.storage.model.AuditEvent>
				getAuditEvents(
					long companyId, long userId, String userName,
					java.util.Date createDateGT, java.util.Date createDateLT,
					String eventType, String className, String classPK,
					String clientHost, String clientIP, String serverName,
					int serverPort, String sessionID, boolean andSearch,
					int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						orderByComparator)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _auditEventService.getAuditEvents(
			companyId, userId, userName, createDateGT, createDateLT, eventType,
			className, classPK, clientHost, clientIP, serverName, serverPort,
			sessionID, andSearch, start, end, orderByComparator);
	}

	@Override
	public int getAuditEventsCount(long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditEventService.getAuditEventsCount(companyId);
	}

	@Override
	public int getAuditEventsCount(
			long companyId, long userId, String userName,
			java.util.Date createDateGT, java.util.Date createDateLT,
			String eventType, String className, String classPK,
			String clientHost, String clientIP, String serverName,
			int serverPort, String sessionID, boolean andSearch)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditEventService.getAuditEventsCount(
			companyId, userId, userName, createDateGT, createDateLT, eventType,
			className, classPK, clientHost, clientIP, serverName, serverPort,
			sessionID, andSearch);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _auditEventService.getOSGiServiceIdentifier();
	}

	@Override
	public AuditEventService getWrappedService() {
		return _auditEventService;
	}

	@Override
	public void setWrappedService(AuditEventService auditEventService) {
		_auditEventService = auditEventService;
	}

	private AuditEventService _auditEventService;

}