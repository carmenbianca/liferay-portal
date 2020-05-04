/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.notifications.web.internal.util.comparator;

import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Alejandro Tardín
 */
public class UserNotificationEventTimestampComparator
	extends OrderByComparator<UserNotificationEvent> {

	public static final String ORDER_BY_ASC =
		"UserNotificationEvent.timestamp ASC";

	public static final String ORDER_BY_DESC =
		"UserNotificationEvent.timestamp DESC";

	public static final String[] ORDER_BY_FIELDS = {"timestamp"};

	public UserNotificationEventTimestampComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(
		UserNotificationEvent userNotificationEvent1,
		UserNotificationEvent userNotificationEvent2) {

		int value = Long.compare(
			userNotificationEvent1.getTimestamp(),
			userNotificationEvent2.getTimestamp());

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	private final boolean _ascending;

}