/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.upgrade.v1_0_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;

/**
 * @author Bryan Engler
 */
public class UpgradeCalendarBooking extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		updateCalendarBooking();
	}

	protected void updateCalendarBooking() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			if (!hasColumn("CalendarBooking", "vEventUid")) {
				runSQL("alter table CalendarBooking add vEventUid STRING null");
			}

			runSQL(
				"update CalendarBooking set vEventUid = uuid_ where " +
					"vEventUid is null or vEventUid = ''");
		}
	}

}