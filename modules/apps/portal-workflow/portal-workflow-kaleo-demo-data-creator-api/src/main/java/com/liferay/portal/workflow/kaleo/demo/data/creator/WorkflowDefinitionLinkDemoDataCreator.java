/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.demo.data.creator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.WorkflowDefinitionLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Inácio Nery
 */
@ProviderType
public interface WorkflowDefinitionLinkDemoDataCreator {

	public WorkflowDefinitionLink create(
			long userId, long companyId, long groupId, String className,
			long classPK, long typePK)
		throws PortalException;

	public void delete() throws PortalException;

}