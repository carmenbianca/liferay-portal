/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.poller.comet;

/**
 * @author Edward Han
 */
public class PollerCometDelayedJobUtil {

	public static void addPollerCometDelayedTask(
		PollerCometDelayedTask pollerCometDelayedTask) {

		getPollerCometDelayedJob().addPollerCometDelayedTask(
			pollerCometDelayedTask);
	}

	public static PollerCometDelayedJob getPollerCometDelayedJob() {
		return _pollerCometDelayedJob;
	}

	public void setPollerCometDelayedJob(
		PollerCometDelayedJob pollerCometDelayedJob) {

		_pollerCometDelayedJob = pollerCometDelayedJob;
	}

	private static PollerCometDelayedJob _pollerCometDelayedJob;

}