/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow;

import com.liferay.portal.kernel.messaging.proxy.BaseProxyBean;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.workflow.WorkflowStatusManager;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Bruno Farache
 */
@OSGiBeanProperties(
	property = "proxy.bean=true", service = WorkflowStatusManager.class
)
public class WorkflowStatusManagerProxyBean
	extends BaseProxyBean implements WorkflowStatusManager {

	@Override
	public void updateStatus(
		int status, Map<String, Serializable> workflowContext) {

		throw new UnsupportedOperationException();
	}

}