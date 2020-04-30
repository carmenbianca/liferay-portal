/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.notification;

import com.liferay.calendar.notification.NotificationRecipient;
import com.liferay.calendar.notification.NotificationSender;
import com.liferay.calendar.notification.NotificationTemplateContext;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eduardo Lundgren
 */
@Component(
	immediate = true, property = "notification.type=im",
	service = NotificationSender.class
)
public class IMNotificationSender implements NotificationSender {

	@Override
	public void sendNotification(
		String fromAddress, String fromName,
		NotificationRecipient notificationRecipient,
		NotificationTemplateContext notificationTemplateContext) {
	}

	@Override
	public void sendNotification(
		String fromAddress, String fromName,
		NotificationRecipient notificationRecipient, String subject,
		String notificationMessage) {
	}

}