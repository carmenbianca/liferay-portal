/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.audit;

import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Greenwald
 * @author Prathima Shreenath
 */
@ProviderType
public interface AuditEventManager {

	public AuditEvent addAuditEvent(AuditMessage auditMessage);

	public AuditEvent fetchAuditEvent(long auditEventId);

	public List<AuditEvent> getAuditEvents(
		long companyId, int start, int end,
		OrderByComparator orderByComparator);

	public List<AuditEvent> getAuditEvents(
		long companyId, long userId, String userName, Date createDateGT,
		Date createDateLT, String eventType, String className, String classPK,
		String clientHost, String clientIP, String serverName, int serverPort,
		String sessionID, boolean andSearch, int start, int end,
		OrderByComparator orderByComparator);

	public int getAuditEventsCount(long companyId);

	public int getAuditEventsCount(
		long companyId, long userId, String userName, Date createDateGT,
		Date createDateLT, String eventType, String className, String classPK,
		String clientHost, String clientIP, String serverName, int serverPort,
		String sessionID, boolean andSearch);

}