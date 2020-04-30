/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.poller.comet;

/**
 * @author Edward Han
 */
public interface PollerCometDelayedJob {

	public void addPollerCometDelayedTask(
		PollerCometDelayedTask pollerCometDelayedTask);

}