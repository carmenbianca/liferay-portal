/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.service;

import com.liferay.calendar.model.CalendarResource;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for CalendarResource. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Eduardo Lundgren
 * @see CalendarResourceServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CalendarResourceService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CalendarResourceServiceUtil} to access the calendar resource remote service. Add custom service methods to <code>com.liferay.calendar.service.impl.CalendarResourceServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public CalendarResource addCalendarResource(
			long groupId, long classNameId, long classPK, String classUuid,
			String code, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, boolean active,
			ServiceContext serviceContext)
		throws PortalException;

	public CalendarResource deleteCalendarResource(long calendarResourceId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CalendarResource fetchCalendarResource(
			long classNameId, long classPK)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CalendarResource getCalendarResource(long calendarResourceId)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CalendarResource> search(
		long companyId, long[] groupIds, long[] classNameIds, String keywords,
		boolean active, boolean andOperator, int start, int end,
		OrderByComparator<CalendarResource> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CalendarResource> search(
		long companyId, long[] groupIds, long[] classNameIds, String code,
		String name, String description, boolean active, boolean andOperator,
		int start, int end,
		OrderByComparator<CalendarResource> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchCount(
		long companyId, long[] groupIds, long[] classNameIds, String keywords,
		boolean active);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchCount(
		long companyId, long[] groupIds, long[] classNameIds, String code,
		String name, String description, boolean active, boolean andOperator);

	public CalendarResource updateCalendarResource(
			long calendarResourceId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, boolean active,
			ServiceContext serviceContext)
		throws PortalException;

}