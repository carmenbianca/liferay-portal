/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.metrics.sla.calendar;

import java.util.Locale;
import java.util.Map;

/**
 * @author Rafael Praxedes
 */
public interface WorkflowMetricsSLACalendarTracker {

	public WorkflowMetricsSLACalendar getWorkflowMetricsSLACalendar(String key);

	public Map<String, String> getWorkflowMetricsSLACalendarTitles(
		Locale locale);

}