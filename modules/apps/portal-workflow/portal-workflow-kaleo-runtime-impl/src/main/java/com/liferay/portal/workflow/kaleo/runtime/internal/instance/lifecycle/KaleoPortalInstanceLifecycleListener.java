/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.internal.instance.lifecycle;

import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.workflow.kaleo.runtime.WorkflowEngine;
import com.liferay.portal.workflow.kaleo.runtime.internal.messaging.KaleoWorkflowMessagingConfigurator;
import com.liferay.portal.workflow.kaleo.runtime.manager.PortalKaleoManager;
import com.liferay.portal.workflow.kaleo.service.KaleoConditionLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoNodeLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTransitionLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class KaleoPortalInstanceLifecycleListener
	extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		_portalKaleoManager.deployKaleoDefaults(company.getCompanyId());
	}

	@Reference(unbind = "-")
	protected void setKaleoConditionLocalService(
		KaleoConditionLocalService kaleoConditionLocalService) {
	}

	@Reference(unbind = "-")
	protected void setKaleoDefinitionLocalService(
		KaleoDefinitionLocalService kaleoDefinitionLocalService) {
	}

	@Reference(unbind = "-")
	protected void setKaleoNodeLocalService(
		KaleoNodeLocalService kaleoNodeLocalService) {
	}

	@Reference(unbind = "-")
	protected void setKaleoTaskLocalService(
		KaleoTaskLocalService kaleoTaskLocalService) {
	}

	@Reference(unbind = "-")
	protected void setKaleoTransitionLocalService(
		KaleoTransitionLocalService kaleoTransitionLocalService) {
	}

	@Reference
	private KaleoWorkflowMessagingConfigurator
		_kaleoWorkflowMessagingConfigurator;

	@Reference
	private PortalKaleoManager _portalKaleoManager;

	@Reference
	private WorkflowEngine _workflowEngine;

}