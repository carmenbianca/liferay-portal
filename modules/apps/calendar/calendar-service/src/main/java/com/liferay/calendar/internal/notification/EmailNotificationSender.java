/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.notification;

import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.model.CalendarNotificationTemplateConstants;
import com.liferay.calendar.notification.NotificationField;
import com.liferay.calendar.notification.NotificationRecipient;
import com.liferay.calendar.notification.NotificationSender;
import com.liferay.calendar.notification.NotificationSenderException;
import com.liferay.calendar.notification.NotificationTemplateContext;
import com.liferay.calendar.notification.NotificationUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;

import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Lundgren
 */
@Component(
	immediate = true, property = "notification.type=email",
	service = NotificationSender.class
)
public class EmailNotificationSender implements NotificationSender {

	@Override
	public void sendNotification(
			String fromAddress, String fromName,
			NotificationRecipient notificationRecipient,
			NotificationTemplateContext notificationTemplateContext)
		throws NotificationSenderException {

		try {
			CalendarNotificationTemplate calendarNotificationTemplate =
				notificationTemplateContext.getCalendarNotificationTemplate();

			String fromAddressValue = NotificationUtil.getTemplatePropertyValue(
				calendarNotificationTemplate,
				CalendarNotificationTemplateConstants.PROPERTY_FROM_ADDRESS,
				fromAddress);
			String fromNameValue = NotificationUtil.getTemplatePropertyValue(
				calendarNotificationTemplate,
				CalendarNotificationTemplateConstants.PROPERTY_FROM_NAME,
				fromName);

			notificationTemplateContext.setFromAddress(fromAddressValue);
			notificationTemplateContext.setFromName(fromNameValue);
			notificationTemplateContext.setToAddress(
				notificationRecipient.getEmailAddress());
			notificationTemplateContext.setToName(
				notificationRecipient.getName());

			String subject = NotificationTemplateRenderer.render(
				notificationTemplateContext, NotificationField.SUBJECT,
				NotificationTemplateRenderer.MODE_PLAIN);
			String body = NotificationTemplateRenderer.render(
				notificationTemplateContext, NotificationField.BODY,
				NotificationTemplateRenderer.MODE_HTML);

			sendNotification(
				notificationTemplateContext.getFromAddress(),
				notificationTemplateContext.getFromName(),
				notificationRecipient, subject, body);
		}
		catch (Exception exception) {
			throw new NotificationSenderException(exception);
		}
	}

	@Override
	public void sendNotification(
			String fromAddress, String fromName,
			NotificationRecipient notificationRecipient, String subject,
			String notificationMessage)
		throws NotificationSenderException {

		try {
			InternetAddress fromInternetAddress = new InternetAddress(
				fromAddress, fromName);

			MailMessage mailMessage = new MailMessage(
				fromInternetAddress, subject, notificationMessage, true);

			mailMessage.setHTMLFormat(notificationRecipient.isHTMLFormat());

			InternetAddress toInternetAddress = new InternetAddress(
				notificationRecipient.getEmailAddress());

			mailMessage.setTo(toInternetAddress);

			_mailService.sendEmail(mailMessage);
		}
		catch (Exception exception) {
			throw new NotificationSenderException(
				"Unable to send mail message", exception);
		}
	}

	@Reference
	private MailService _mailService;

}