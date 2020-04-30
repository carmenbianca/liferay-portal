/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.notifications;

import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Edward Han
 */
public interface NotificationEventFactory {

	public NotificationEvent createNotificationEvent(
		long timestamp, String type, JSONObject payloadJSONObject);

}