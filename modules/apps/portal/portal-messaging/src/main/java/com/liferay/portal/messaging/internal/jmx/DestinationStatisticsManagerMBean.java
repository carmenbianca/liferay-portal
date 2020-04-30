/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.messaging.internal.jmx;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public interface DestinationStatisticsManagerMBean {

	public int getActiveThreadCount();

	public int getCurrentThreadCount();

	public int getLargestThreadCount();

	public String getLastRefresh();

	public int getMaxThreadPoolSize();

	public int getMinThreadPoolSize();

	public long getPendingMessageCount();

	public long getSentMessageCount();

	public boolean isAutoRefresh();

	public void refresh();

	public void setAutoRefresh(boolean autoRefresh);

}