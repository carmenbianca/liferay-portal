/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.notifications.internal.util;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.SubscriptionSender;

/**
 * @author Alejandro Tardín
 */
public class SharingNotificationSubcriptionSender extends SubscriptionSender {

	@Override
	protected void populateNotificationEventJSONObject(
		JSONObject notificationEventJSONObject) {

		super.populateNotificationEventJSONObject(notificationEventJSONObject);

		notificationEventJSONObject.put("message", subject);
	}

}