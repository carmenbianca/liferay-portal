/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender;

/**
 * @author Bruno Farache
 */
public interface Response {

	public String getId();

	public String getPayload();

	public String getPlatform();

	public String getStatus();

	public String getToken();

	public boolean isSucceeded();

}