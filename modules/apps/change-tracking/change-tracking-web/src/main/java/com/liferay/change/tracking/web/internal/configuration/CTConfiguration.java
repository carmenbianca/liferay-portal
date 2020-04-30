/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Tomas Polesovsky
 */
@ExtendedObjectClassDefinition(category = "infrastructure")
@Meta.OCD(
	id = "com.liferay.change.tracking.web.internal.configuration.CTConfiguration",
	localization = "content/Language",
	name = "change-tracking-portal-configuration-name"
)
public interface CTConfiguration {

	@Meta.AD(
		deflt = "Administrator", name = "administrator-role-names",
		required = false
	)
	public String[] administratorRoleNames();

}