/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scheduler;

import java.util.Date;
import java.util.TimeZone;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Tina Tian
 */
@ProviderType
public interface TriggerFactory {

	public Trigger createTrigger(
		String jobName, String groupName, Date startDate, Date endDate,
		int interval, TimeUnit timeUnit);

	public Trigger createTrigger(
		String jobName, String groupName, Date startDate, Date endDate,
		String cronExpression);

	public Trigger createTrigger(
		String jobName, String groupName, Date startDate, Date endDate,
		String cronExpression, TimeZone timeZone);

	public Trigger createTrigger(Trigger trigger, Date startDate, Date endDate);

}