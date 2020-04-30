/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.upgrade.v3_0_0;

import com.liferay.calendar.internal.upgrade.v3_0_0.util.CalendarTable;
import com.liferay.calendar.model.Calendar;
import com.liferay.portal.upgrade.util.BaseUpgradeResourceBlock;

/**
 * @author Preston Crary
 */
public class UpgradeCalendarResourceBlock extends BaseUpgradeResourceBlock {

	@Override
	protected String getClassName() {
		return Calendar.class.getName();
	}

	@Override
	protected String getPrimaryKeyName() {
		return "calendarId";
	}

	@Override
	protected Class<?> getTableClass() {
		return CalendarTable.class;
	}

	@Override
	protected boolean hasUserId() {
		return false;
	}

}