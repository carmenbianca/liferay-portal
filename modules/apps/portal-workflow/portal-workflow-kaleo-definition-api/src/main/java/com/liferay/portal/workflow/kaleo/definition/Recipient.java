/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

/**
 * @author Michael C. Han
 */
public abstract class Recipient {

	public Recipient(RecipientType recipientType) {
		_recipientType = recipientType;
	}

	public NotificationReceptionType getNotificationReceptionType() {
		return _notificationReceptionType;
	}

	public RecipientType getRecipientType() {
		return _recipientType;
	}

	public void setNotificationReceptionType(
		NotificationReceptionType notificationReceptionType) {

		_notificationReceptionType = notificationReceptionType;
	}

	private NotificationReceptionType _notificationReceptionType;
	private final RecipientType _recipientType;

}