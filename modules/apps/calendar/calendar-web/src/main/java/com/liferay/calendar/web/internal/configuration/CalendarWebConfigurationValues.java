/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.web.internal.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Adam Brandizzi
 */
public class CalendarWebConfigurationValues {

	public static final boolean CALENDAR_SYNC_CALEVENTS_ON_STARTUP =
		GetterUtil.getBoolean(
			CalendarWebConfigurationUtil.get(
				"calendar.sync.calevents.on.startup"));

}