/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.configuration.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Peter Petrekanics
 */
@ExtendedObjectClassDefinition(category = "users")
@Meta.OCD(
	id = "com.liferay.portlet.configuration.web.internal.configuration.RoleVisibilityConfiguration",
	localization = "content/Language",
	name = "role-visibility-configuration-name"
)
public interface RoleVisibilityConfiguration {

	@Meta.AD(
		deflt = "false",
		description = "restrict-permission-selector-role-visibility-description",
		name = "restrict-permission-selector-role-visibility-name",
		required = false
	)
	public boolean restrictPermissionSelectorRoleVisibility();

}