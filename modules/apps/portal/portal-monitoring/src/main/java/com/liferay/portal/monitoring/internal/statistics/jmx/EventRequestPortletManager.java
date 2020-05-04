/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.monitoring.internal.statistics.jmx;

import com.liferay.portal.monitoring.internal.statistics.portlet.EventRequestSummaryStatistics;

import javax.management.DynamicMBean;
import javax.management.NotCompliantMBeanException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	enabled = false, immediate = true,
	property = {
		"jmx.objectname=com.liferay.portal.monitoring:classification=portlet_statistic,name=EventRequestPortletManager",
		"jmx.objectname.cache.key=EventRequestPortletManager"
	},
	service = DynamicMBean.class
)
public class EventRequestPortletManager extends PortletManager {

	public EventRequestPortletManager() throws NotCompliantMBeanException {
		super(PortletManagerMBean.class);
	}

	@Reference(unbind = "-")
	protected void setEventRequestSummaryStatistics(
		EventRequestSummaryStatistics eventRequestSummaryStatistics) {

		super.setPortletSummaryStatistics(eventRequestSummaryStatistics);
	}

}