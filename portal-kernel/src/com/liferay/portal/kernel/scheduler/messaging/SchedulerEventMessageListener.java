/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scheduler.messaging;

import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;

/**
 * @author Michael C. Han
 */
public interface SchedulerEventMessageListener extends MessageListener {

	public SchedulerEntry getSchedulerEntry();

}