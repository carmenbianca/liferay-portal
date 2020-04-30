/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

/**
 * @author Bruno Farache
 */
public interface PushNotificationsSender {

	public void send(List<String> tokens, JSONObject payloadJSONObject)
		throws Exception;

}