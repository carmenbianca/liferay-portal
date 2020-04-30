/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scheduler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.BasePortalLifecycle;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

/**
 * @author Tina Tian
 */
public class SchedulerLifecycle extends BasePortalLifecycle {

	@Override
	protected void doPortalDestroy() throws Exception {
	}

	@Override
	protected void doPortalInit() throws Exception {
		Registry registry = RegistryUtil.getRegistry();

		registry.callService(
			SchedulerEngineHelper.class,
			schedulerEngineHelper -> {
				try {
					schedulerEngineHelper.start();
				}
				catch (SchedulerException schedulerException) {
					_log.error(
						"Unable to start scheduler engine", schedulerException);
				}

				return null;
			});
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SchedulerLifecycle.class);

}