/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.upgrade.v1_0_5;

import com.liferay.calendar.constants.CalendarPortletKeys;
import com.liferay.portal.kernel.util.LoggingTimer;

/**
 * @author Máté Thurzó
 */
public class UpgradeLastPublishDate
	extends com.liferay.portal.upgrade.v7_0_0.UpgradeLastPublishDate {

	protected void addLastPublishDateColumns() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			addLastPublishDateColumn("Calendar");
			addLastPublishDateColumn("CalendarBooking");
			addLastPublishDateColumn("CalendarNotificationTemplate");
			addLastPublishDateColumn("CalendarResource");
		}
	}

	@Override
	protected void doUpgrade() throws Exception {
		addLastPublishDateColumns();

		updateLastPublishDates(CalendarPortletKeys.CALENDAR, "Calendar");
		updateLastPublishDates(CalendarPortletKeys.CALENDAR, "CalendarBooking");
		updateLastPublishDates(
			CalendarPortletKeys.CALENDAR, "CalendarNotificationTemplate");
		updateLastPublishDates(
			CalendarPortletKeys.CALENDAR, "CalendarResource");
	}

}