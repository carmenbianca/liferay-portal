/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.search;

/**
 * @author André de Oliveira
 */
public interface CalendarBookingBatchReindexer {

	public void reindex(long calendarId, long companyId);

}