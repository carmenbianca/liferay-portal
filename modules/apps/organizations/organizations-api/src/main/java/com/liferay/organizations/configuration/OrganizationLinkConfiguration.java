/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.organizations.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Drew Brokke
 */
@ExtendedObjectClassDefinition(category = "users")
@Meta.OCD(
	id = "com.liferay.organizations.configuration.OrganizationLinkConfiguration",
	localization = "content/Language",
	name = "organization-link-configuration-name"
)
public interface OrganizationLinkConfiguration {

	@Meta.AD(
		deflt = "false", description = "organization-link-enabled-description",
		name = "enabled", required = false
	)
	public boolean enabled();

	@Meta.AD(
		deflt = "", description = "organization-link-types-description",
		name = "organization-link-types", required = false
	)
	public String[] linkTypes();

}