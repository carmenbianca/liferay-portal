/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.notifications;

import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.journal.model.JournalArticleConstants;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + JournalPortletKeys.JOURNAL,
	service = UserNotificationDefinition.class
)
public class JournalMoveEntryToFolderUserNotificationDefinition
	extends BaseJournalUserNotificationDefinition {

	public JournalMoveEntryToFolderUserNotificationDefinition() {
		super(
			JournalArticleConstants.NOTIFICATION_TYPE_MOVE_ENTRY_TO_FOLDER,
			"receive-a-notification-when-someone-moves-to-folder-web-content-" +
				"you-are-subscribed-to");

		addUserNotificationDeliveryType(
			new UserNotificationDeliveryType(
				"email", UserNotificationDeliveryConstants.TYPE_EMAIL, true,
				true));
		addUserNotificationDeliveryType(
			new UserNotificationDeliveryType(
				"website", UserNotificationDeliveryConstants.TYPE_WEBSITE, true,
				true));
	}

}