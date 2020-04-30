/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scheduler;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public interface SchedulerEntry extends Serializable {

	public String getDescription();

	public String getEventListenerClass();

	public Trigger getTrigger();

}