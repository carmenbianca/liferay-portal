/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.internal.notification;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.UserNotificationManagerUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.workflow.constants.MyWorkflowTasksConstants;
import com.liferay.portal.workflow.kaleo.definition.NotificationReceptionType;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.internal.util.NotificationMessageHelper;
import com.liferay.portal.workflow.kaleo.runtime.notification.BaseNotificationSender;
import com.liferay.portal.workflow.kaleo.runtime.notification.NotificationRecipient;
import com.liferay.portal.workflow.kaleo.runtime.notification.NotificationSender;

import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "notification.type=user-notification",
	service = NotificationSender.class
)
public class UserNotificationMessageSender
	extends BaseNotificationSender implements NotificationSender {

	@Override
	protected void doSendNotification(
			Map<NotificationReceptionType, Set<NotificationRecipient>>
				notificationRecipients,
			String defaultSubject, String notificationMessage,
			ExecutionContext executionContext)
		throws Exception {

		JSONObject jsonObject =
			_notificationMessageHelper.createMessageJSONObject(
				notificationMessage, executionContext);

		for (Map.Entry<NotificationReceptionType, Set<NotificationRecipient>>
				entry : notificationRecipients.entrySet()) {

			for (NotificationRecipient notificationRecipient :
					entry.getValue()) {

				if (notificationRecipient.getUserId() <= 0) {
					continue;
				}

				if (UserNotificationManagerUtil.isDeliver(
						notificationRecipient.getUserId(),
						PortletKeys.MY_WORKFLOW_TASK, 0,
						MyWorkflowTasksConstants.
							NOTIFICATION_TYPE_MY_WORKFLOW_TASKS,
						UserNotificationDeliveryConstants.TYPE_WEBSITE)) {

					_userNotificationEventLocalService.
						sendUserNotificationEvents(
							notificationRecipient.getUserId(),
							PortletKeys.MY_WORKFLOW_TASK,
							UserNotificationDeliveryConstants.TYPE_WEBSITE,
							jsonObject);
				}
			}
		}
	}

	@Reference
	private NotificationMessageHelper _notificationMessageHelper;

	@Reference
	private UserNotificationEventLocalService
		_userNotificationEventLocalService;

}