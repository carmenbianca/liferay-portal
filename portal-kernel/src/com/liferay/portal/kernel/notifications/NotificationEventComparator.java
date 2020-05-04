/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.notifications;

import java.util.Comparator;

/**
 * @author Edward Han
 */
public class NotificationEventComparator
	implements Comparator<NotificationEvent> {

	public NotificationEventComparator() {
		this(true);
	}

	public NotificationEventComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(
		NotificationEvent notificationEvent1,
		NotificationEvent notificationEvent2) {

		if (notificationEvent1.equals(notificationEvent2)) {
			return 0;
		}

		long value =
			notificationEvent1.getDeliverBy() -
				notificationEvent2.getDeliverBy();

		if (value == 0) {
			value =
				notificationEvent1.getTimestamp() -
					notificationEvent2.getTimestamp();
		}

		if (value == 0) {
			value =
				notificationEvent1.hashCode() - notificationEvent2.hashCode();
		}

		if (_ascending) {
			return (int)value;
		}

		return (int)-value;
	}

	private final boolean _ascending;

}