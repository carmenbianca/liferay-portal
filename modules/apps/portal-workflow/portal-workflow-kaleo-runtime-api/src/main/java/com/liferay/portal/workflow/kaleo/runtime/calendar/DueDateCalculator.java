/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.calendar;

import com.liferay.portal.workflow.kaleo.definition.DelayDuration;

import java.util.Date;

/**
 * @author Michael C. Han
 */
public interface DueDateCalculator {

	public Date getDueDate(Date startDate, DelayDuration delayDuration);

}