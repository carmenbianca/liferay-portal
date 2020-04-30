/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exporter;

/**
 * @author Marcellus Tavares
 */
public interface CalendarDataHandler {

	public String exportCalendar(long calendarId) throws Exception;

	public String exportCalendarBooking(long calendarBookingId)
		throws Exception;

	public void importCalendar(long calendarId, String data) throws Exception;

}