/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.demo.data.creator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Inácio Nery
 */
@ProviderType
public interface WorkflowInstanceDemoDataCreator {

	public WorkflowInstance getWorkflowInstance(
			long companyId, long workflowInstanceId)
		throws WorkflowException;

	public WorkflowInstance getWorkflowInstance(
			long companyId, String assetClassName, long assetClassPK)
		throws Exception;

	public void updateCompletionDate(
			long workflowInstanceId, Date completionDate)
		throws Exception;

	public void updateCreateDate(long workflowInstanceId, Date createDate)
		throws PortalException;

}