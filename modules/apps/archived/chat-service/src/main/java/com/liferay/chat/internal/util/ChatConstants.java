/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.chat.internal.util;

import com.liferay.portal.kernel.util.Time;

/**
 * @author Brian Wing Shun Chan
 */
public class ChatConstants {

	public static final long MAX_POLL_LATENCY = Time.SECOND * 15;

	public static final long ONLINE_DELTA = Time.MINUTE;

}