/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.scheduler.quartz.internal;

import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerLifecycle;
import com.liferay.portal.kernel.util.PortalLifecycle;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(enabled = false, immediate = true, service = {})
public class SchedulerLifecycleInitializer {

	@Activate
	protected void activate() {
		SchedulerLifecycle schedulerLifecycle = new SchedulerLifecycle();

		schedulerLifecycle.registerPortalLifecycle(PortalLifecycle.METHOD_INIT);
	}

	@Reference(unbind = "-")
	protected void setQuartzSchemaManager(
		QuartzSchemaManager quartzSchemaManager) {
	}

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(
		SchedulerEngineHelper schedulerEngineHelper) {
	}

}