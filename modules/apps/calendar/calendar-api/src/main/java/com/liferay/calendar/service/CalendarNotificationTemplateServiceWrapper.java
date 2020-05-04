/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CalendarNotificationTemplateService}.
 *
 * @author Eduardo Lundgren
 * @see CalendarNotificationTemplateService
 * @generated
 */
public class CalendarNotificationTemplateServiceWrapper
	implements CalendarNotificationTemplateService,
			   ServiceWrapper<CalendarNotificationTemplateService> {

	public CalendarNotificationTemplateServiceWrapper(
		CalendarNotificationTemplateService
			calendarNotificationTemplateService) {

		_calendarNotificationTemplateService =
			calendarNotificationTemplateService;
	}

	@Override
	public com.liferay.calendar.model.CalendarNotificationTemplate
			addCalendarNotificationTemplate(
				long calendarId,
				com.liferay.calendar.notification.NotificationType
					notificationType,
				String notificationTypeSettings,
				com.liferay.calendar.notification.NotificationTemplateType
					notificationTemplateType,
				String subject, String body,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarNotificationTemplateService.
			addCalendarNotificationTemplate(
				calendarId, notificationType, notificationTypeSettings,
				notificationTemplateType, subject, body, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _calendarNotificationTemplateService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.calendar.model.CalendarNotificationTemplate
			updateCalendarNotificationTemplate(
				long calendarNotificationTemplateId,
				String notificationTypeSettings, String subject, String body,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarNotificationTemplateService.
			updateCalendarNotificationTemplate(
				calendarNotificationTemplateId, notificationTypeSettings,
				subject, body, serviceContext);
	}

	@Override
	public CalendarNotificationTemplateService getWrappedService() {
		return _calendarNotificationTemplateService;
	}

	@Override
	public void setWrappedService(
		CalendarNotificationTemplateService
			calendarNotificationTemplateService) {

		_calendarNotificationTemplateService =
			calendarNotificationTemplateService;
	}

	private CalendarNotificationTemplateService
		_calendarNotificationTemplateService;

}