/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.monitoring.internal.statistics.jmx;

import com.liferay.portal.monitoring.internal.statistics.service.ServerStatistics;

import javax.management.DynamicMBean;
import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	enabled = false, immediate = true,
	property = {
		"jmx.objectname=com.liferay.portal.monitoring:classification=service_statistic,name=ServiceManager",
		"jmx.objectname.cache.key=ServiceManager"
	},
	service = DynamicMBean.class
)
public class ServiceManager
	extends StandardMBean implements ServiceManagerMBean {

	public ServiceManager() throws NotCompliantMBeanException {
		super(ServiceManagerMBean.class);
	}

	@Override
	public long getErrorCount(
		String className, String methodName, String[] parameterTypes) {

		return _serverStatistics.getErrorCount(
			className, methodName, parameterTypes);
	}

	@Override
	public long getMaxTime(
		String className, String methodName, String[] parameterTypes) {

		return _serverStatistics.getMaxTime(
			className, methodName, parameterTypes);
	}

	@Override
	public long getMinTime(
		String className, String methodName, String[] parameterTypes) {

		return _serverStatistics.getMinTime(
			className, methodName, parameterTypes);
	}

	@Override
	public long getRequestCount(
		String className, String methodName, String[] parameterTypes) {

		return _serverStatistics.getRequestCount(
			className, methodName, parameterTypes);
	}

	@Reference(unbind = "-")
	protected void setServerStatistics(ServerStatistics serverStatistics) {
		_serverStatistics = serverStatistics;
	}

	private ServerStatistics _serverStatistics;

}