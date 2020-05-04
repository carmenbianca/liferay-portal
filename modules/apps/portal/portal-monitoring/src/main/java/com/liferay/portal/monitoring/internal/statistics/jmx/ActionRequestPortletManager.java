/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.monitoring.internal.statistics.jmx;

import com.liferay.portal.monitoring.internal.statistics.portlet.ActionRequestSummaryStatistics;

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
		"jmx.objectname=com.liferay.portal.monitoring:classification=portlet_statistic,name=ActionRequestPortletManager",
		"jmx.objectname.cache.key=ActionRequestPortletManager"
	},
	service = DynamicMBean.class
)
public class ActionRequestPortletManager extends PortletManager {

	public ActionRequestPortletManager() throws NotCompliantMBeanException {
		super(PortletManagerMBean.class);
	}

	@Reference(unbind = "-")
	protected void setActionRequestSummaryStatistics(
		ActionRequestSummaryStatistics actionRequestSummaryStatistics) {

		super.setPortletSummaryStatistics(actionRequestSummaryStatistics);
	}

}