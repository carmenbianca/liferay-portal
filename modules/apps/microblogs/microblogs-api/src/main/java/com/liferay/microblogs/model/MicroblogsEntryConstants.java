/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.microblogs.model;

/**
 * @author Jonathan Lee
 */
public class MicroblogsEntryConstants {

	public static final int NOTIFICATION_TYPE_REPLY = 0;

	public static final int NOTIFICATION_TYPE_REPLY_TO_REPLIED = 1;

	public static final int NOTIFICATION_TYPE_REPLY_TO_TAGGED = 2;

	public static final int NOTIFICATION_TYPE_TAG = 3;

	public static final int NOTIFICATION_TYPE_UNKNOWN = -1;

	public static final int TYPE_EVERYONE = 0;

	public static final int TYPE_REPLY = 1;

	public static final int TYPE_REPOST = 2;

}