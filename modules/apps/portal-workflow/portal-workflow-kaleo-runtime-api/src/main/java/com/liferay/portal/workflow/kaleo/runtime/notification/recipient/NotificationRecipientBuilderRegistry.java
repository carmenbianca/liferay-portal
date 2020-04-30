/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.notification.recipient;

import com.liferay.portal.workflow.kaleo.definition.RecipientType;

/**
 * @author Michael C. Han
 */
public interface NotificationRecipientBuilderRegistry {

	public NotificationRecipientBuilder getNotificationRecipientBuilder(
		RecipientType recipientType);

}