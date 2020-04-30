/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.deployment;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.workflow.kaleo.definition.Definition;

/**
 * @author Michael C. Han
 */
public interface WorkflowDeployer {

	public default WorkflowDefinition deploy(
			String title, String name, Definition definition,
			ServiceContext serviceContext)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	public default WorkflowDefinition save(
			String title, String name, Definition definition,
			ServiceContext serviceContext)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

}