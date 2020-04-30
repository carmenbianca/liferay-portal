/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow;

import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowStatusManager;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Bruno Farache
 */
public class WorkflowStatusManagerImpl implements WorkflowStatusManager {

	@Override
	public void updateStatus(
			int status, Map<String, Serializable> workflowContext)
		throws WorkflowException {

		try {
			WorkflowHandlerRegistryUtil.updateStatus(status, workflowContext);
		}
		catch (Exception exception) {
			throw new WorkflowException(exception);
		}
	}

}