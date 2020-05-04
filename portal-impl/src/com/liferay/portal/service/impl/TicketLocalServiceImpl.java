/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Ticket;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.service.base.TicketLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * @author Mika Koivisto
 */
public class TicketLocalServiceImpl extends TicketLocalServiceBaseImpl {

	@Override
	public Ticket addDistinctTicket(
		long companyId, String className, long classPK, int type,
		String extraInfo, Date expirationDate, ServiceContext serviceContext) {

		ticketPersistence.removeByC_C_C_T(
			companyId, classNameLocalService.getClassNameId(className), classPK,
			type);

		return addTicket(
			companyId, className, classPK, type, extraInfo, expirationDate,
			serviceContext);
	}

	@Override
	public Ticket addTicket(
		long companyId, String className, long classPK, int type,
		String extraInfo, Date expirationDate, ServiceContext serviceContext) {

		long classNameId = classNameLocalService.getClassNameId(className);

		long ticketId = counterLocalService.increment();

		Ticket ticket = ticketPersistence.create(ticketId);

		ticket.setCompanyId(companyId);
		ticket.setCreateDate(new Date());
		ticket.setClassNameId(classNameId);
		ticket.setClassPK(classPK);
		ticket.setKey(PortalUUIDUtil.generate());
		ticket.setType(type);
		ticket.setExtraInfo(extraInfo);
		ticket.setExpirationDate(expirationDate);

		return ticketPersistence.update(ticket);
	}

	@Override
	public Ticket fetchTicket(String key) {
		return ticketPersistence.fetchByKey(key);
	}

	@Override
	public Ticket getTicket(String key) throws PortalException {
		return ticketPersistence.findByKey(key);
	}

	@Override
	public List<Ticket> getTickets(
		long companyId, String className, long classPK, int type) {

		return ticketPersistence.findByC_C_C_T(
			companyId, classNameLocalService.getClassNameId(className), classPK,
			type);
	}

	@Override
	public List<Ticket> getTickets(String className, long classPK, int type) {
		return ticketPersistence.findByC_C_T(
			classNameLocalService.getClassNameId(className), classPK, type);
	}

	@Override
	public Ticket updateTicket(
			long ticketId, String className, long classPK, int type,
			String extraInfo, Date expirationDate)
		throws PortalException {

		long classNameId = classNameLocalService.getClassNameId(className);

		Ticket ticket = ticketPersistence.findByPrimaryKey(ticketId);

		ticket.setClassNameId(classNameId);
		ticket.setClassPK(classPK);
		ticket.setType(type);
		ticket.setExtraInfo(extraInfo);
		ticket.setExpirationDate(expirationDate);

		return ticketPersistence.update(ticket);
	}

}