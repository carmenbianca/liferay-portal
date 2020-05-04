/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.microblogs.web.internal.notifications;

import com.liferay.microblogs.constants.MicroblogsPortletKeys;
import com.liferay.microblogs.model.MicroblogsEntryConstants;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + MicroblogsPortletKeys.MICROBLOGS,
	service = UserNotificationDefinition.class
)
public class MicroblogsReplyToRepliedUserNotificationDefinition
	extends UserNotificationDefinition {

	public MicroblogsReplyToRepliedUserNotificationDefinition() {
		super(
			MicroblogsPortletKeys.MICROBLOGS, 0,
			MicroblogsEntryConstants.NOTIFICATION_TYPE_REPLY_TO_REPLIED,
			"receive-a-notification-when-someone-comments-on-a-microblog-you-" +
				"commented-on");

		addUserNotificationDeliveryType(
			new UserNotificationDeliveryType(
				"mobile", UserNotificationDeliveryConstants.TYPE_PUSH, true,
				true));
		addUserNotificationDeliveryType(
			new UserNotificationDeliveryType(
				"website", UserNotificationDeliveryConstants.TYPE_WEBSITE, true,
				true));
	}

}