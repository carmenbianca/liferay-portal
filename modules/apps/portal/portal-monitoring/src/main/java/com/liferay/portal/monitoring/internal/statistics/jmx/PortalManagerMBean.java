/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.monitoring.internal.statistics.jmx;

import com.liferay.portal.kernel.monitoring.MonitoringException;
import com.liferay.portal.monitoring.internal.statistics.SummaryStatistics;

/**
 * @author Karthik Sudarshan
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public interface PortalManagerMBean extends SummaryStatistics {

	public long[] getCompanyIds() throws MonitoringException;

	public long getUptime(long companyId) throws MonitoringException;

	public long getUptime(String companyWebId) throws MonitoringException;

	public String[] getWebIds() throws MonitoringException;

	public void reset();

	public void reset(long companyId);

	public void reset(String webId);

}