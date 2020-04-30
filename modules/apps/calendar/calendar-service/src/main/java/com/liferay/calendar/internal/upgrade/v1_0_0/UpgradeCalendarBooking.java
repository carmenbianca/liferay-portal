/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.upgrade.v1_0_0;

import com.liferay.calendar.internal.upgrade.v1_0_0.util.CalendarBookingTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Bryan Engler
 */
public class UpgradeCalendarBooking extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			CalendarBookingTable.class,
			new AlterColumnType("description", "TEXT null"));
	}

}