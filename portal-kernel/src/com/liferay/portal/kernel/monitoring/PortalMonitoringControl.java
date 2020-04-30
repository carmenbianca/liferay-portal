/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.monitoring;

/**
 * @author Michael C. Han
 */
public interface PortalMonitoringControl {

	public boolean isMonitorPortalRequest();

	public void setMonitorPortalRequest(boolean monitorPortalRequest);

}