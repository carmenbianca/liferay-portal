/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.upgrade.v3_0_0;

import com.liferay.calendar.internal.upgrade.v3_0_0.util.CalendarBookingTable;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.portal.upgrade.util.BaseUpgradeResourceBlock;

/**
 * @author Preston Crary
 */
public class UpgradeCalendarBookingResourceBlock
	extends BaseUpgradeResourceBlock {

	@Override
	protected String getClassName() {
		return CalendarBooking.class.getName();
	}

	@Override
	protected String getPrimaryKeyName() {
		return "calendarBookingId";
	}

	@Override
	protected Class<?> getTableClass() {
		return CalendarBookingTable.class;
	}

	@Override
	protected boolean hasUserId() {
		return true;
	}

}