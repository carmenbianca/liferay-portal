/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.model.adapter.builder;

import com.liferay.portal.kernel.model.WorkflowDefinitionLink;
import com.liferay.portal.kernel.model.adapter.StagedGroupedWorkflowDefinitionLink;
import com.liferay.portal.kernel.model.adapter.builder.ModelAdapterBuilder;
import com.liferay.portal.model.adapter.impl.StagedGroupedWorkflowDefinitionLinkImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Zoltan Csaszi
 */
@Component(immediate = true, service = ModelAdapterBuilder.class)
public class StagedGroupedWorkflowDefinitionLinkModelAdapterBuilder
	implements ModelAdapterBuilder
		<WorkflowDefinitionLink, StagedGroupedWorkflowDefinitionLink> {

	@Override
	public StagedGroupedWorkflowDefinitionLink build(
		WorkflowDefinitionLink workflowDefinitionLink) {

		return new StagedGroupedWorkflowDefinitionLinkImpl(
			workflowDefinitionLink);
	}

}