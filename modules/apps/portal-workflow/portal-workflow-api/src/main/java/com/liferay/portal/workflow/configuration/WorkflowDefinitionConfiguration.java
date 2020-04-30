/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Tomas Polesovsky
 */
@ExtendedObjectClassDefinition(category = "workflow")
@Meta.OCD(
	id = "com.liferay.portal.workflow.configuration.WorkflowDefinitionConfiguration",
	localization = "content/Language",
	name = "workflow-definition-configuration-name"
)
public interface WorkflowDefinitionConfiguration {

	@Meta.AD(
		deflt = "false",
		description = "allow-administrators-to-publish-and-edit-workflows-description",
		id = "company.administrator.can.publish",
		name = "allow-administrators-to-publish-and-edit-workflows",
		required = false
	)
	public boolean companyAdministratorCanPublish();

}