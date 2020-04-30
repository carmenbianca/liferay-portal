/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.monitoring.internal.statistics.jmx;

/**
 * @author Michael C. Han
 */
public interface ServiceManagerMBean {

	public long getErrorCount(
		String className, String methodName, String[] parameterTypes);

	public long getMaxTime(
		String className, String methodName, String[] parameterTypes);

	public long getMinTime(
		String className, String methodName, String[] parameterTypes);

	public long getRequestCount(
		String className, String methodName, String[] parameterTypes);

}