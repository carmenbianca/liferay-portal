/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.workflow;

import com.liferay.portal.kernel.messaging.proxy.MessagingProxy;
import com.liferay.portal.kernel.messaging.proxy.ProxyMode;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Bruno Farache
 */
@MessagingProxy(mode = ProxyMode.ASYNC)
public interface WorkflowStatusManager {

	public void updateStatus(
			int status, Map<String, Serializable> workflowContext)
		throws WorkflowException;

}