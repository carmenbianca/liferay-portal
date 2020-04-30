/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.upgrade.v1_0_5;

import com.liferay.portal.kernel.upgrade.BaseUpgradeCompanyId;

/**
 * @author Inácio Nery
 */
public class UpgradeCompanyId extends BaseUpgradeCompanyId {

	@Override
	protected TableUpdater[] getTableUpdaters() {
		return new TableUpdater[] {
			new TableUpdater(
				"RatingsStats", "classPK",
				new String[][] {{"CalendarBooking", "calendarBookingId"}})
		};
	}

}