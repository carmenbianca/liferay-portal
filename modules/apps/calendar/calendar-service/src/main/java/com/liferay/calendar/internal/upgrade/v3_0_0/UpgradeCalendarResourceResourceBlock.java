/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.upgrade.v3_0_0;

import com.liferay.calendar.internal.upgrade.v3_0_0.util.CalendarResourceTable;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.portal.upgrade.util.BaseUpgradeResourceBlock;

/**
 * @author Preston Crary
 */
public class UpgradeCalendarResourceResourceBlock
	extends BaseUpgradeResourceBlock {

	@Override
	protected String getClassName() {
		return CalendarResource.class.getName();
	}

	@Override
	protected String getPrimaryKeyName() {
		return "calendarResourceId";
	}

	@Override
	protected Class<?> getTableClass() {
		return CalendarResourceTable.class;
	}

	@Override
	protected boolean hasUserId() {
		return true;
	}

}