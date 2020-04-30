/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.metrics.sla.calendar;

import java.time.Duration;
import java.time.LocalDateTime;

import java.util.Locale;

/**
 * @author Inácio Nery
 */
public interface WorkflowMetricsSLACalendar {

	public Duration getDuration(
		LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime);

	public LocalDateTime getOverdueLocalDateTime(
		LocalDateTime nowLocalDateTime, Duration remainingDuration);

	public String getTitle(Locale locale);

}